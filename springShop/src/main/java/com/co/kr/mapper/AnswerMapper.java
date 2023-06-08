package com.co.kr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.AnswerDomain;

@Mapper
public interface AnswerMapper {

	void insertAnswer(AnswerDomain answerDomain) throws Exception;
}
