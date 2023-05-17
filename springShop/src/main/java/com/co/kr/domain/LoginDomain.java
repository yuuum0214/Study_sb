package com.co.kr.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder(builderMethodName="builder")
public class LoginDomain {
	
	private Integer smbSeq;
	private String smbId;
	private String smbPw;
	private String smbLevel;
	private String smbIp;
	private String smbUse;
	private String smbCreate;
	private String smbUpdate;

}
