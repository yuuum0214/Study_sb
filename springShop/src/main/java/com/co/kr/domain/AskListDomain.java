package com.co.kr.domain;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder(builderMethodName="builder")
@Data
public class AskListDomain {

	private Integer ibSeq;
	private String cType;
	private String ibTitle;
	private String smbId;
	private String ibContent;
	private String ibCreate;
	private List<AskFileDomain> askFileList;
	
	
}


