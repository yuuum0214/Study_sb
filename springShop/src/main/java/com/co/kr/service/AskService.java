package com.co.kr.service;

import java.util.List;

import com.co.kr.domain.AskListDomain;

public interface AskService {

	List<AskListDomain> selectAskList() throws Exception;
	
	//ask게시판 작성
	void insertAsk(AskListDomain askListDomain) throws Exception;

	//게시글 상세보기
	AskListDomain selectAskDetail(int ibSeq) throws Exception;
	
	//게시글 수정
	void updateAsk(AskListDomain askListDomain) throws Exception;
	
	//게시글 삭제
	void deleteAsk(int ibSeq) throws Exception;
	
}