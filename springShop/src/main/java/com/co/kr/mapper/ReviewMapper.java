package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.ReviewListDomain;

@Mapper
public interface ReviewMapper {
	
	List<ReviewListDomain> selectReviewList() throws Exception;

}
