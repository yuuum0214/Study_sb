package com.co.kr.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.co.kr.domain.AskListDomain;
import com.co.kr.vo.AskFileListVO;

public interface AskService {

	List<AskListDomain> selectAskList() throws Exception;
	
	//ask게시판 작성
	//void insertAsk(AskListDomain askListDomain) throws Exception;

	//게시글 상세보기
	AskListDomain selectAskDetail(int ibSeq) throws Exception;
	
	//게시글 수정
	void updateAsk(AskListDomain askListDomain) throws Exception;
	
	//게시글 삭제
	void deleteAsk(int ibSeq) throws Exception;
	
	//게시판 작성 + 파일 입력
//	void insertAsk(AskListDomain askListDomain, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	// 게시판 작성 + 파일 입력
	void insertAsk(AskListDomain askListDomain, MultipartHttpServletRequest multipartHttpServletRequest, String smbId) throws Exception;

}