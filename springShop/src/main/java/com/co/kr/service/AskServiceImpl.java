package com.co.kr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.AskListDomain;
import com.co.kr.mapper.AskMapper;

@Service
public class AskServiceImpl implements AskService {
	
	@Autowired
	private AskMapper askMapper;
	
	@Override
	public List<AskListDomain> selectAskList() throws Exception {
		return askMapper.selectAskList();
	}
}
