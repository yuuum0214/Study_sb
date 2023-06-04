package com.co.kr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.BoardListDomain;
import com.co.kr.domain.LoginDomain;
import com.co.kr.service.AskService;
import com.co.kr.service.MemberService;
import com.co.kr.service.UploadService;
import com.co.kr.service.UserService;
import com.co.kr.util.CommonUtils;
import com.co.kr.vo.LoginVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class MemberController {

	 // 진입점
    @GetMapping("/")
    public String index() {
        return "index.html";
    }


    //회원관리 예제
/*    @GetMapping("/member")
    public String member() {
    	return "member.html";
    }
  */
  
	//회원관리 리스트
	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member")
	public ModelAndView openUserList() throws Exception{
		ModelAndView mav = new ModelAndView("/member");
		
		List<LoginDomain> list = memberService.smbAllList();
		mav.addObject("lists", list);
		
		return mav;
	}
	
	//멤버추가 작성란
	@RequestMapping("/member/memberInsert")
	public String addMember() throws Exception{
		return "member/memberInsert";
	}
	//멤버 추가 후 이동
	@RequestMapping("/member/insertMember")
	public String insertMember(LoginDomain loginDomain) throws Exception{
		memberService.insertMember(loginDomain);
		return "redirect:/member";
	}


    
/*  @GetMapping("/login")
    public String login() {
    	return "login.html";
    }

    @Autowired
    private UserService userService;


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
            return "login.html";
        }

        // 현재아이피 추출
        String IP = CommonUtils.getClientIP(request);

        // session 저장
        session.setAttribute("ip", IP);
        session.setAttribute("id", loginDomain.getSmbId());
        session.setAttribute("smbLevel", loginDomain.getSmbLevel());

//        List<BoardListDomain> items = uploadService.boardList();
//        System.out.println("items ==> " + items);
        // 모델에 items 추가
//        model.addAttribute("items", items);

        return "redirect:/"; // 로그인 성공 시 홈 페이지로 리다이렉트
    } */
    
    
    
    

	
}
