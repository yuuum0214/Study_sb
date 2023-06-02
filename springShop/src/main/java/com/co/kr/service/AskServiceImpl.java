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
	
	//ask게시글작성
	@Override
	public void insertAsk(AskListDomain askListDomain) throws Exception {
		askMapper.insertAsk(askListDomain);
	}
	
	//ask상세보기
	@Override
	public AskListDomain selectAskDetail(int ibSeq) throws Exception{
		AskListDomain askListDomain = askMapper.selectAskDetail(ibSeq);
		
		return askListDomain;
	}
	
	//ask게시글 수정
	@Override
	public void updateAsk(AskListDomain askListDomain) throws Exception{
		askMapper.updateAsk(askListDomain);
	}
	
	//ask게시글 삭제
	@Override
	public void deleteAsk(int ibSeq) throws Exception{
		askMapper.deleteAsk(ibSeq);
	}
	
}
