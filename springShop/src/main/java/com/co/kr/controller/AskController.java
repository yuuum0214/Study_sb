package com.co.kr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class AskController {

	@GetMapping("/projects")
	public String projects() {
		return "projects.html";
	}
	
	@GetMapping("/projects/askEdit")
	public String askEdit() {
		return "askEdit.html";
	}
	
}
