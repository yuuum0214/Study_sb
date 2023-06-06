package com.co.kr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.LoginDomain;
import com.co.kr.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public LoginDomain smbSelectList(Map<String, String> map) {
		return userMapper.smbSelectList(map);
	}
	
	@Override
	public List<LoginDomain> smbAllList(Map<String, Integer> map) { 
		return userMapper.smbAllList(map);
	}
	
	@Override
	public int smbGetAll() {
		// TODO Auto-generated method stub
		return userMapper.smbGetAll();
	}

	@Override
	public int smbDuplicationCheck(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userMapper.smbDuplicationCheck(map);
	}

	
	@Override
	public LoginDomain smbGetId(Map<String, String> map) {
		return userMapper.smbGetId(map);
	}

	
	//signup
	@Override
	public void openSignup(LoginDomain loginDomain) throws Exception {
		userMapper.openSignup(loginDomain);
		
	}


}
