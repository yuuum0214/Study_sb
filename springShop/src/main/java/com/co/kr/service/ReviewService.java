package com.co.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.ReviewListDomain;

@Service
public interface ReviewService {
	//목록 조회
	List<ReviewListDomain> selectReviewList() throws Exception;
	
	//content insert
	void insertReview(ReviewListDomain reviewListDomain) throws Exception;
	
	//상세 보기
	ReviewListDomain selectReviewDetail(int rbSeq) throws Exception;
	
	//게시글 수정
	void updateReview(ReviewListDomain reviewListDomain) throws Exception;
		
	//게시글 삭제
	void deleteReview(int rbSeq) throws Exception;


}
