package com.co.kr.controller;

import java.io.IOException;
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

import com.co.kr.domain.LoginDomain;
import com.co.kr.domain.ReviewListDomain;
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
	
	@GetMapping("/login")
    public String login() {
    	return "login.html";
    }

    @RequestMapping(value = "/login")
    public String login(LoginVO loginDTO, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

        // session 처리
        HttpSession session = request.getSession();
        // 중복체크
        Map<String, String> map = new HashMap<>();
        map.put("smbId", loginDTO.getId());
        map.put("smbPw", loginDTO.getPw());

        // 중복체크
        int dupleCheck = userService.smbDuplicationCheck(map);
        LoginDomain loginDomain = userService.smbGetId(map);

        if (dupleCheck == 0) {
            String alertText = "없는 아이디이거나 패스워드가 잘못되었습니다. 가입해주세요";
            String redirectPath = "/signin";
            CommonUtils.redirect(alertText, redirectPath, response);
            return "redirect:/login";
        }

        // 현재아이피 추출
        String IP = CommonUtils.getClientIP(request);

        // session 저장
        session.setAttribute("ip", IP);
        session.setAttribute("id", loginDomain.getSmbId());
        session.setAttribute("smbLevel", loginDomain.getSmbLevel());

//        List<ReviewListDomain> items = reviewService.selectReviewList();
//        System.out.println("items ==> " + items);
        // 모델에 items 추가
//        model.addAttribute("items", items);

        return "redirect:/"; // 로그인 성공 시 홈 페이지로 리다이렉트
    }


}
