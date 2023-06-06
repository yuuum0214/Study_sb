package com.co.kr.service;

import java.util.List;
import java.util.Map;

import com.co.kr.domain.LoginDomain;
public interface UserService {
	
	//전체 리스트 조회
    public LoginDomain smbSelectList(Map<String, String> map);
    
    //전체데이터
    public List<LoginDomain> smbAllList(Map<String, Integer> map);
    
    // 전체갯수
    public int smbGetAll();
    
    //중복체크
    public int smbDuplicationCheck(Map<String, String> map);
    
    //id 정보 가져오기
    public LoginDomain smbGetId(Map<String, String> map);
    
    //signup
    void openSignup(LoginDomain loginDomain) throws Exception;

}
