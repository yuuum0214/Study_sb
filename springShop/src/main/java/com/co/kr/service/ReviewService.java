package com.co.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.ReviewFileDomain;
import com.co.kr.domain.ReviewListDomain;

@Service
public interface ReviewService {
	//목록 조회
	List<ReviewListDomain> selectReviewList() throws Exception;
	
	//content insert
	void insertReview(ReviewListDomain reviewListDomain, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	//상세 보기
	ReviewListDomain selectReviewDetail(int rbSeq) throws Exception;
	
	//게시글 수정
	void updateReview(ReviewListDomain reviewListDomain) throws Exception;
		
	//게시글 삭제
	void deleteReview(int rbSeq) throws Exception;

	//삭제 후 rb_seq와 중복되지 않는 가장 작은 수 생성
	int ReviewSeq();

	List<ReviewFileDomain> getReviewFiles(int rbSeq);
	
	
	
	
	// 인서트 및 업데이트
	/*public int fileProcess(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq);
			
	// 하나 삭제
	public void rbContentRemove(HashMap<String, Object> map);
			
	// 하나 삭제
	public void rbFileRemove(ReviewFileDomain reviewFileDomain);

	// 하나 리스트 조회
	public ReviewListDomain boardSelectOne(HashMap<String, Object> map);
		
	// 하나 파일 리스트 조회
	public List<ReviewFileDomain> boardSelectOneFile(HashMap<String, Object> map);*/


}
