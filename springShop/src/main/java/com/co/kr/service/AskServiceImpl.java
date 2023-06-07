package com.co.kr.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.co.kr.code.Code;
import com.co.kr.common.AskFileUtils;
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
	
	//파일업로드
	@Autowired
	private AskFileUtils askfileUtils;
	
	@Override
	public List<AskListDomain> selectAskList() throws Exception {
		return askMapper.selectAskList();
	}
	
	//ask게시글작성
/*	@Override
	public void insertAsk(AskListDomain askListDomain) throws Exception {
		askMapper.insertAsk(askListDomain);
	}*/
	
	//ask게시글작성+파일첨부
	@Override
	public void insertAsk(AskListDomain askListDomain, MultipartHttpServletRequest multipartHttpServletRequest, String smbId) throws Exception {
		//session의 smb_id 들고오기
		askListDomain.setSmbId(smbId);
		
		askMapper.insertAsk(askListDomain);
		
		List<AskFileDomain> list = askfileUtils.parseFileInfo(askListDomain.getIbSeq(), multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false) {
			for(AskFileDomain fileDomain : list) {
				fileDomain.setSmbId(smbId); //각 파일에 smb_id 설정 , session에서 id를 들고옴으로 에러 해결
			}
			askMapper.insertAskFileList(list);
		}	
		 //파일 유입 테스트
		if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false){
			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
			String name;
			while(iterator.hasNext()) {
				name = iterator.next();
				System.out.println("file tag name : "+name);
				List<MultipartFile> lists = multipartHttpServletRequest.getFiles(name);
				for(MultipartFile multipartFile : lists) {
					System.out.println("start file information");
					System.out.println("file name : "+multipartFile.getOriginalFilename());
					System.out.println("file size : "+multipartFile.getSize());
					System.out.println("file content type : "+multipartFile.getContentType());
					System.out.println("end file information.\n");
				}
			}
		}
	}
	
	//ask상세보기
	@Override
	public AskListDomain selectAskDetail(int ibSeq) throws Exception{
		AskListDomain askListDomain = askMapper.selectAskDetail(ibSeq);
		List<AskFileDomain> askFileList = askMapper.selectAskFileList(ibSeq);
//		askListDomain.setAskFileList(askFileList);
		
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
	
}
