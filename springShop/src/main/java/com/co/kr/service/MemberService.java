package com.co.kr.service;

import java.util.List;

import com.co.kr.domain.LoginDomain;

public interface MemberService {

	List<LoginDomain> smbAllList() throws Exception;
	
}
