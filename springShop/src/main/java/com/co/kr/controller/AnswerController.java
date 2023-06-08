package com.co.kr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.co.kr.domain.AnswerDomain;
import com.co.kr.service.AnswerService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;

	//답변하기 이동
	@RequestMapping("/ask/askqueryEdit")
	public String openAnswer() throws Exception{
		return "ask/askqueryEdit";
	}
	
	@RequestMapping("/ask/insertAnswer")
	public String insertAnswer(AnswerDomain answerDomain) throws Exception {
		answerService.insertAnswer(answerDomain);
		return "redirect:/ask";
	}
}
