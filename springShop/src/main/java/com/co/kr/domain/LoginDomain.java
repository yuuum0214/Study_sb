package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
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
