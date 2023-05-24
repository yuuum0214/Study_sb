package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName="builder")
public class AskListDomain {

	private String ibSeq;
	private String cType;
	private String smbId;
	private String ibTitle;
//	private String ibContent;
	private String ibCreate;

}
