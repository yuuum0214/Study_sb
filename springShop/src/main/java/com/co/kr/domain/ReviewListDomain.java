package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName="builder")
public class ReviewListDomain {
	
	private Integer rbSeq;
	private String smbId;
	private String rbTitle;
	private String rbContent;
	private String rbCreate;
	private String rbUpdate;

}
