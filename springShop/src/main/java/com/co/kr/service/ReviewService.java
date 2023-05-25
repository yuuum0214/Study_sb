package com.co.kr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.co.kr.domain.ReviewListDomain;

@Service
public interface ReviewService {
	
	List<ReviewListDomain> selectReviewList() throws Exception;

}
