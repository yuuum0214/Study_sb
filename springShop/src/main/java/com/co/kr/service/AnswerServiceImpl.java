package com.co.kr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.domain.AnswerDomain;
import com.co.kr.mapper.AnswerMapper;

@Service
public class AnswerServiceImpl implements AnswerService{
	
	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public void insertAnswer(AnswerDomain answerDomain) throws Exception{
		answerMapper.insertAnswer(answerDomain);
	}
}
