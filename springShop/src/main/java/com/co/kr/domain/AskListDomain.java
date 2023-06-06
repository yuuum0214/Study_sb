package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName="builder")
public class AskListDomain {

	private Integer ibSeq;
	private String cType;
	private String ibTitle;
	private String smbId;
	private String ibContent;
	private String ibCreate;

}
