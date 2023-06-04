package com.co.kr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.co.kr.domain.LoginDomain;
import com.co.kr.service.MemberService;

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
	
	//멤버 사용여부 수정
	@RequestMapping("/member/updateMember")
	public String updateMember(@RequestParam("smbSeq") int smbSeq, @RequestParam("smbUse") String smbUse) throws Exception {
	    String firstCharacter = smbUse.substring(0, 1); // 입력값의 맨 앞 문자 추출
	    LoginDomain loginDomain = LoginDomain.builder()
	        .smbSeq(smbSeq)
	        .smbUse(firstCharacter)
	        .build();
	    memberService.updateMember(loginDomain);
	    return "redirect:/member";
	}// 멤버 사용여부 수정



	//멤버 삭제
	@RequestMapping("/member/deleteMember")
	public String deleteMember(int smbSeq) throws Exception{
		memberService.deleteMember(smbSeq);
		return "redirect:/member";
	}
	

}
