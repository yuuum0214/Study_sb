package com.co.kr.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.service.AskService;
import com.co.kr.vo.AskFileListVO;

public class AskFileListController {

	@Autowired
	private AskService askService;
	
	
	
	/*
	//문의사항에 파일 첨부해서 새로 연동
	@PostMapping(value = "/ask/insertAsk")
	public ModelAndView insertAsk(AskFileListVO askFileListVO, MultipartHttpServletRequest request,
								HttpServletRequest httpRequest) throws IOException, ParseException
	{
		ModelAndView mav = new ModelAndView();
		int ibSeq = askService.fileProcess(askFileListVO, request, httpRequest);
		askFileListVO.setContent("");
		askFileListVO.setTitle("");
		
		mav = askListSelect(askFileListVO, String.valueOf(ibSeq), request);
		mav.setViewName("ask.html");
		return mav;
	}
	
	private ModelAndView askListSelect(AskFileListVO askFileListVO, String valueOf,
			MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
