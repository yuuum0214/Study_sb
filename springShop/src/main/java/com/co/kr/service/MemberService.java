package com.co.kr.service;

import java.util.List;

import com.co.kr.domain.LoginDomain;

public interface MemberService {

	List<LoginDomain> smbAllList() throws Exception;
	
	//멤버 추가
	void insertMember(LoginDomain loginDomain) throws Exception;
	
	//멤버 사용여부 수정
	void updateMember(LoginDomain loginDomain) throws Exception;
	
	//멤버 삭제
	void deleteMember(LoginDomain loginDomain) throws Exception;

	void deleteMember(int smbSeq) throws Exception;
	

}
