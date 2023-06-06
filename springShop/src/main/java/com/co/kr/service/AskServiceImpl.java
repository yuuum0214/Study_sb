package com.co.kr.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.co.kr.code.Code;
import com.co.kr.domain.AskFileDomain;
import com.co.kr.domain.AskListDomain;
import com.co.kr.exception.RequestException;
import com.co.kr.mapper.AskMapper;
import com.co.kr.util.CommonUtils;
import com.co.kr.vo.AskFileListVO;

@Service
public class AskServiceImpl implements AskService {
	
	@Autowired
	private AskMapper askMapper;
	
	@Override
	public List<AskListDomain> selectAskList() throws Exception {
		return askMapper.selectAskList();
	}
	
	//ask게시글작성
	@Override
	public void insertAsk(AskListDomain askListDomain) throws Exception {
		askMapper.insertAsk(askListDomain);
	}
	
	//ask상세보기
	@Override
	public AskListDomain selectAskDetail(int ibSeq) throws Exception{
		AskListDomain askListDomain = askMapper.selectAskDetail(ibSeq);
		
		return askListDomain;
	}
	
	//ask게시글 수정
	@Override
	public void updateAsk(AskListDomain askListDomain) throws Exception{
		askMapper.updateAsk(askListDomain);
	}
	
	//ask게시글 삭제
	@Override
	public void deleteAsk(int ibSeq) throws Exception{
		askMapper.deleteAsk(ibSeq);
	}

	@Override
	public int fileProcess(AskFileListVO askFileListVO, MultipartHttpServletRequest request,
			HttpServletRequest httpReq) {
		HttpSession session = httpReq.getSession();
		
		AskListDomain askListDomain = AskListDomain.builder()
				.smbId(session.getAttribute("id").toString())
				.ibTitle(askFileListVO.getTitle())
				.ibContent(askFileListVO.getContent())
				.build();
		
		int ibSeq = askListDomain.getIbSeq();
		String smbId = askListDomain.getSmbId();
		
		List<MultipartFile> multipartFiles = request.getFiles("file");
		
		if(askFileListVO.getIsEdit() != null) {
			List<AskFileDomain> fileList = null;
			
			for(MultipartFile multipartFile : multipartFiles) {
				if(!multipartFile.isEmpty()) {
					if(session.getAttribute("file") != null) {
						fileList = (List<AskFileDomain>) session.getAttribute("file");
						
						for(AskFileDomain list : fileList) {
							list.getIbFilePath();
							Path filePath = Paths.get(list.getIbFilePath());
							
							try {
								Files.deleteIfExists(filePath);
								
							} catch (DirectoryNotEmptyException e) {
								throw RequestException.fire(Code.E404, "디렉토리가 존재하지 않습니다", HttpStatus.NOT_FOUND);
					        } catch (IOException e) {
					            e.printStackTrace();
					        }
						}
					}
				}
			}
		}
		
		//새로운 파일 저장 : root 경로 만들기
		Path rootPath = Paths.get(new File("E://").toString(), "Upload", File.separator).toAbsolutePath().normalize();
		File pathCheck = new File(rootPath.toString());
		
		if(!pathCheck.exists()) pathCheck.mkdirs();
		
		for(MultipartFile multipartFile : multipartFiles) {
			if(!multipartFile.isEmpty()) {
				String originalFileExtension;
				String contentType = multipartFile.getContentType();
				String origFilename = multipartFile.getOriginalFilename();
				
				if(ObjectUtils.isEmpty(contentType)) {
					break;
				}else {
					if(contentType.contains("image/jpeg")) {
						originalFileExtension = ".jpg";
					}else if(contentType.contains("image/png")) {
						originalFileExtension = ".png";
					}else {
						break;
					}
				}
				
				String uuid = UUID.randomUUID().toString();
				String current = CommonUtils.currentTime();
				String newFileName = uuid + current + originalFileExtension;
				
				Path targetPath = rootPath.resolve(newFileName);
				
				File file = new File(targetPath.toString());
				
				try {
					multipartFile.transferTo(file);
					file.setWritable(true);
					file.setReadable(true);
					
					AskFileDomain askFileDomain = AskFileDomain.builder()
							.ibSeq(ibSeq)
							.smbId(smbId)
							.ibOrigFile(origFilename)
							.ibNewFile("resources/upload/"+newFileName)
							.ibFilePath(targetPath.toString())
							.ibFileSize((int)multipartFile.getSize())
							.build();
					
					askMapper.askFileUpload(askFileDomain);
					System.out.println("upload seccess");
				} catch (IOException e) {
					throw RequestException.fire(Code.E404, "잘못된 업로드 파일입니다.", HttpStatus.NOT_FOUND);
				}
			}
		}
		
		return ibSeq;
		/*
		AskListDomain askListDomain = AskListDomain.builder()
				.smbId(session.getAttribute("id").toString())
				.ibTitle(askFileListVO.getTitle())
				.ibContent(askFileListVO.getContent())
				.build();
		
				if(askFileListVO.getIsEdit() != null) {
					askListDomain.setIbSeq(Integer.parseInt(askFileListVO.getSeq()));
					System.out.println("수정업데이트");
				}
				*/
	}
	
}
