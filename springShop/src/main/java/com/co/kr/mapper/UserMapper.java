package com.co.kr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.LoginDomain;

@Mapper
public interface UserMapper {
	
	//전체 리스트 조회
    public LoginDomain smbSelectList(Map<String, String> map);
    
    
    //전체데이터
    public List<LoginDomain> smbAllList(Map<String, Integer> map);
    
    // 전체갯수
    public int smbGetAll();
    
    //id 정보 가져오기
    public LoginDomain smbGetId(Map<String, String> map);


	public int smbDuplicationCheck(Map<String, String> map);
    

   
    
}
