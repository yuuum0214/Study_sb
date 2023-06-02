package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.domain.AskListDomain;
import com.co.kr.service.AskService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class AskController {

	/*
	//문의사항으로 이동
	@GetMapping("/projects")
	public String projects() {
		return "projects.html";
	}
	*/
	
	//문의사항 리스트
	@Autowired
	private AskService askService;
	
	@RequestMapping("/ask")
	public ModelAndView openAskList() throws Exception{
		ModelAndView mav = new ModelAndView("/ask");
		
		List<AskListDomain> list = askService.selectAskList();
		mav.addObject("lists", list);
		
		return mav;
	}

	//문의사항 작성란
	@RequestMapping("/ask/askEdit")
	public String openAskEdit() throws Exception{
		return "ask/askEdit";
	}
	//문의사항 작성 후 연동
	@RequestMapping("/ask/insertAsk")
	public String insertAsk(AskListDomain askListDomain) throws Exception{
		askService.insertAsk(askListDomain);
		return "redirect:/ask";
	}
	
	//문의사항 읽어오기
	@RequestMapping("/ask/openAskDetail")
	public ModelAndView openAskDetail(@RequestParam int ibSeq) throws Exception{
		ModelAndView mav = new ModelAndView("/ask/askDetail");
		
		AskListDomain askListDomain = askService.selectAskDetail(ibSeq);
		mav.addObject("askListDomain", askListDomain);
		
		return mav;
	}
	
	//문의사항 수정
	@RequestMapping("/ask/updateAsk")
	public String updateAsk(AskListDomain askListDomain) throws Exception{
		askService.updateAsk(askListDomain);
		return "redirect:/ask";
	}
	
	//문의사항 삭제
	@RequestMapping("/ask/deleteAsk")
	public String deleteAsk(int ibSeq) throws Exception{
		askService.deleteAsk(ibSeq);
		return "redirect:/ask";
	}
	
}
