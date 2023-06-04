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
	
	//멤버 추가
	@Override
	public void insertMember(LoginDomain loginDomain) throws Exception{
		memberMapper.insertMember(loginDomain);
	}
	
	//멤버 사용여부 수정
	@Override
	public void updateMember(LoginDomain loginDomain) throws Exception{
		memberMapper.updateMember(loginDomain);
	}
	
	@Override
	public void deleteMember(int smbSeq) throws Exception{
		memberMapper.deleteMember(smbSeq);
	}

	@Override
	public void deleteMember(LoginDomain loginDomain) throws Exception {
	    memberMapper.deleteMember(loginDomain.getSmbSeq());
	}


}
