package com.co.kr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class UserController {

	//진입점
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/resume")
	public String resume() {
		return "resume.html";
	}
	
	@GetMapping("/projects")
	public String projects() {
		return "projects.html";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login.html";
	}
}
