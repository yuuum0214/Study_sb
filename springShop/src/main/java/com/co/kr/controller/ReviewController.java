package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping("/resume")
	public ModelAndView openReviewList() throws Exception { 
		ModelAndView mav = new ModelAndView("/resume");
		
		List<ReviewListDomain> list = reviewService.selectReviewList();
		mav.addObject("list", list);
		
		return mav; 
	}

}
