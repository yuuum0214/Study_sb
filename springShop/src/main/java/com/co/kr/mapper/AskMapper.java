package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.AskListDomain;

@Mapper
public interface AskMapper {

	List<AskListDomain> selectAskList() throws Exception;
}
