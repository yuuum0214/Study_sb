package com.co.kr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.LoginDomain;
import com.co.kr.domain.ReviewListDomain;
import com.co.kr.service.AskService;
import com.co.kr.service.ReviewService;
import com.co.kr.service.UserService;
import com.co.kr.util.CommonUtils;
import com.co.kr.vo.LoginVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private AskService askService;
	
	@GetMapping("/signup")
	public String signup() {
		return "signup.html";
	}
	
	@GetMapping("/login")
    public String showLogin() {
    	return "login.html";
    }
	
	

	@PostMapping(value = "/login")
	public String login(LoginVO loginDTO, HttpServletRequest request, Model model) throws Exception {

		log.info("login method called");

		// session 처리
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView();
		// 중복체크
		Map<String, String> map = new HashMap<>();
		map.put("smbId", loginDTO.getId());
		map.put("smbPw", loginDTO.getPw());

		// 중복체크
		int dupleCheck = userService.smbDuplicationCheck(map);
		LoginDomain loginDomain = userService.smbGetId(map);

		if (dupleCheck == 0) {
			String alertText = "없는 아이디이거나 패스워드가 잘못되었습니다. 다시 입력해주세요";
			model.addAttribute("alertText", alertText);
			return "login.html";
		}

		// 현재 아이피 추출
		String IP = CommonUtils.getClientIP(request);

		// session 저장
		session.setAttribute("ip", IP);
		session.setAttribute("id", loginDomain.getSmbId());
		session.setAttribute("smbLevel", loginDomain.getSmbLevel());
		
		List<ReviewListDomain> lists = reviewService.selectReviewList();
		System.out.println("lists ==> "+ lists);
		mav.addObject("lists", lists);

		return "redirect:/"; // 로그인 성공 시 홈 페이지로 리다이렉트
	}
	
	// 로그아웃 기능
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	
	// id,pw 작성
	@RequestMapping("/signup")
	public String signupWrite() throws Exception{
		return "signup";
	}
	
	// 회원가입 작성 후 이동
	@PostMapping("/signup")
	public String openSignup(LoginDomain loginDomain) throws Exception{
		userService.openSignup(loginDomain);
		return "redirect:/login";
	}
	
	
	
}



