package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.ReviewListDomain;

@Mapper
public interface ReviewMapper {
	
	//content list
	List<ReviewListDomain> selectReviewList() throws Exception;
	
	//content insert
	void insertReview(ReviewListDomain reviewListDomain) throws Exception;

	//상세 보기
	ReviewListDomain selectReviewDetail(int rbSeq) throws Exception;
	
}
