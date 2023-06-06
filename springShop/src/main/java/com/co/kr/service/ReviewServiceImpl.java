package com.co.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.BoardListDomain;
import com.co.kr.domain.ReviewListDomain;
import com.co.kr.mapper.ReviewMapper;
import com.co.kr.mapper.UploadMapper;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	@Override
	public List<ReviewListDomain> selectReviewList() throws Exception {
		return reviewMapper.selectReviewList();
	}
	
	@Override
	public void insertReview(ReviewListDomain reviewListDomain) throws Exception{
		reviewMapper.insertReview(reviewListDomain);
	}
	
	@Override
	public ReviewListDomain selectReviewDetail(int rbSeq) throws Exception {
		ReviewListDomain reviewListDomain = reviewMapper.selectReviewDetail(rbSeq);
		
		return reviewListDomain;
	}
	
	@Override
	public void updateReview(ReviewListDomain reviewListDomain) throws Exception{
		reviewMapper.updateReview(reviewListDomain);
	}
		
	@Override
	public void deleteReview(int rbSeq) throws Exception{
		reviewMapper.deleteReview(rbSeq);
	}
	
	@Override
	public int ReviewSeq() {
		return reviewMapper.ReviewSeq();
	}
	
	
	/*	@Override
	public int fileProcess(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq) {
		//session 생성
		HttpSession session = httpReq.getSession();
		
		//content domain 생성 
		ReviewContentDomain reviewContentDomain = ReviewContentDomain.builder()
				.smbId(session.getAttribute("id").toString())
				.rbTitle(fileListVO.getTitle())
				.rbContent(fileListVO.getContent())
				.build();
		
				if(fileListVO.getIsEdit() != null) {
					reviewContentDomain.setRbSeq(Integer.parseInt(fileListVO.getSeq()));
					System.out.println("수정업데이트");
					// db 업데이트
					reviewMapper.rbContentUpdate(reviewContentDomain);
				}else {	
					// db 인서트
					reviewMapper.contentUpload(reviewContentDomain);
					System.out.println(" db 인서트");

				}
				
				// file 데이터 db 저장시 쓰일 값 추출
				int rbSeq = reviewContentDomain.getRbSeq();
				String smbId = reviewContentDomain.getSmbId();
				
				//파일객체 담음
				List<MultipartFile> multipartFiles = request.getFiles("files");
				
				
				// 게시글 수정시 파일관련 물리저장 파일, db 데이터 삭제 
				if(fileListVO.getIsEdit() != null) { // 수정시 

	
					List<ReviewFileDomain> fileList = null;
					
					
					
					for (MultipartFile multipartFile : multipartFiles) {
					
					
						if(!multipartFile.isEmpty()) {   // 수정시 새로 파일 첨부될때 세션에 담긴 파일 지우기
							
							
							if(session.getAttribute("files") != null) {	

								fileList = (List<ReviewFileDomain>) session.getAttribute("files");
								
								for (ReviewFileDomain list : fileList) {
									list.getRbFilePath();
									Path filePath = Paths.get(list.getRbFilePath());
							 
							        try {
							        	
							            // 파일 삭제
							            Files.deleteIfExists(filePath); // notfound시 exception 발생안하고 false 처리
							            //삭제 
													rbFileRemove(list); //데이터 삭제
										
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
				
				
				///////////////////////////// 새로운 파일 저장 ///////////////////////
				
				// 저장 root 경로만들기
				Path rootPath = Paths.get(new File("C://").toString(),"upload", File.separator).toAbsolutePath().normalize();			
				File pathCheck = new File(rootPath.toString());
				
				// folder chcek
				if(!pathCheck.exists()) pathCheck.mkdirs();
				
	
				for (MultipartFile multipartFile : multipartFiles) {
					
					if(!multipartFile.isEmpty()) {  // 파일 있을때 
						
						//확장자 추출
						String originalFileExtension;
						String contentType = multipartFile.getContentType();
						String origFilename = multipartFile.getOriginalFilename();
						
						//확장자 존재하지 않을 경우
						if(ObjectUtils.isEmpty(contentType)){
							break;
						}else { // 확장자가 jpeg, png인 파일들만 받아서 처리
							if(contentType.contains("image/jpeg")) {
								originalFileExtension = ".jpg";
							}else if(contentType.contains("image/png")) {
								originalFileExtension = ".png";
							}else {
								break;
							}
						}
						
						//파일명을 업로드한 날짜로 변환하여 저장
						String uuid = UUID.randomUUID().toString();
						String current = CommonUtils.currentTime();
						String newFileName = uuid + current + originalFileExtension;
						
						//최종경로까지 지정
						Path targetPath = rootPath.resolve(newFileName);
						
						File file = new File(targetPath.toString());
						
						try {
							//파일복사저장
							multipartFile.transferTo(file);
							// 파일 권한 설정(쓰기, 읽기)
							file.setWritable(true);
							file.setReadable(true);
							
							
							//파일 domain 생성 
							ReviewFileDomain reviewFileDomain = ReviewFileDomain.builder()
									.rbSeq(rbSeq)
									.smbId(smbId)
									.rbOrigFile(origFilename)
									.rbNewFile("resources/upload/"+newFileName) // WebConfig에 동적 이미지 폴더 생성 했기때문
									.rbFilePath(targetPath.toString())
									.rbFileSize((int)multipartFile.getSize())
									.build();
							
								// db 인서트
								reviewMapper.fileUpload(reviewFileDomain);
								System.out.println("upload done");
							
						} catch (IOException e) {
							throw RequestException.fire(Code.E404, "잘못된 업로드 파일", HttpStatus.NOT_FOUND);
						}
					}

				}
				
		
				return rbSeq; // 저장된 게시판 번호
	}


	// 컨텐츠 삭제
	@Override
	public void rbContentRemove(HashMap<String, Object> map) {
		reviewMapper.rbContentRemove(map);
	}
	
  // 파일 삭제
	@Override
	public void rbFileRemove(ReviewFileDomain reviewFileDomain) {
		reviewMapper.rbFileRemove(reviewFileDomain);
	}
	
	
	@Override
	public ReviewListDomain boardSelectOne(HashMap<String, Object> map) {
		return reviewMapper.boardSelectOne(map);
	}

	// 하나 게시글 파일만 가져오기
	@Override
	public List<ReviewFileDomain> boardSelectOneFile(HashMap<String, Object> map) {
		return reviewMapper.boardSelectOneFile(map);
	} */


}
