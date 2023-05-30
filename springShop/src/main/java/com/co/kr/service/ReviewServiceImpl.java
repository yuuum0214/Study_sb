package com.co.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
