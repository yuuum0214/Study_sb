package com.co.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.LoginDomain;
import com.co.kr.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public List<LoginDomain> smbAllList() throws Exception {
		return memberMapper.smbAllList();
	}
	
	
}
