package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.BoardListDomain;
import com.co.kr.domain.ReviewListDomain;
import com.co.kr.service.ReviewService;
import com.co.kr.service.UploadService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;
    
//  리뷰
    @RequestMapping("/review")
	public ModelAndView openReviewList() throws Exception { 
		ModelAndView mav = new ModelAndView("/review");
		
		List<ReviewListDomain> list = reviewService.selectReviewList();
		mav.addObject("lists", list);
		
		return mav; 
	}
    
//  글쓰기
    @RequestMapping("/review/reviewWrite")
	public String openReviewWrite() throws Exception{
		return "/review/reviewWrite";
	}
    
    
//  작성된 게시글을 등록하는 주소
    @RequestMapping("/review/insertReview")
	public String insertReview(ReviewListDomain reviewListDomain) throws Exception{
    	reviewService.insertReview(reviewListDomain);
		return "redirect:/review";
	}
    
//  상세 화면
    @RequestMapping("review/openReviewDetail")
    public ModelAndView openReviewDetail(@RequestParam int rbSeq) throws Exception{
    	ModelAndView mav = new ModelAndView("/review/reviewDetail");
    	
    	ReviewListDomain reviewListDomain = reviewService.selectReviewDetail(rbSeq);
    	mav.addObject("reviewListDomain", reviewListDomain);
    	
    	return mav;
    }
    

//  수정
  	@RequestMapping("/review/updateReview")
  	public String updateReview(ReviewListDomain reviewListDomain) throws Exception{
  		reviewService.updateReview(reviewListDomain);
  		return "redirect:/review";
  	}
  	
//  삭제
  	@RequestMapping("/review/deleteReview")
  	public String deleteReview(int rbSeq) throws Exception{
  		reviewService.deleteReview(rbSeq);
  		return "redirect:/review";
  	}
    

    
}
