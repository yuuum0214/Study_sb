package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.LoginDomain;

@Mapper
public interface MemberMapper {

	List<LoginDomain> smbAllList() throws Exception;

	//멤버 추가
	void insertMember(LoginDomain loginDomain) throws Exception;
	
	//멤버 사용여부 수정
	void updateMember(LoginDomain loginDomain) throws Exception;
	
	//멤버 삭제
	void deleteMember(int smbSeq) throws Exception;
}
