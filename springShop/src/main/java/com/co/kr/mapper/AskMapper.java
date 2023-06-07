package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.AskFileDomain;
import com.co.kr.domain.AskListDomain;

@Mapper
public interface AskMapper {

	List<AskListDomain> selectAskList() throws Exception;
	
	//ask게시글 작성
	void insertAsk(AskListDomain askListDomain) throws Exception;
	
	//ask상세보기
	AskListDomain selectAskDetail(int ibSeq) throws Exception;
	
	//ask수정하기
	void updateAsk(AskListDomain askListDomain) throws Exception;
	
	//ask삭제하기
	void deleteAsk(int ibSeq) throws Exception;
	
	//ask File 추가
	void insertAskFileList(List<AskFileDomain> list) throws Exception;
}
