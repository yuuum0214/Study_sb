package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.domain.AskListDomain;
import com.co.kr.service.AskService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class AskController {

	//문의사항 리스트
	@Autowired
	private AskService askService;
//	private AskListDomain askListDomain;
	
	@RequestMapping("/ask")
	public ModelAndView openAskList() throws Exception{
		ModelAndView mav = new ModelAndView("/ask");
		
		List<AskListDomain> list = askService.selectAskList();
		mav.addObject("lists", list);
		
		return mav;
	}
/*
	//문의사항 작성란
	@RequestMapping("ask/askEdit")
	public String openAskEdit() throws Exception{
		return "ask/askEdit";
	}
	*/
	/*
	//작성게시글 등록주소
	@RequestMapping("/ask/insertAsk")
	public String insertAsk() throws Exception{
		askService.insertAsk(askListDomain);
		return "redirect:/ask";
	}
	*/
	
}
