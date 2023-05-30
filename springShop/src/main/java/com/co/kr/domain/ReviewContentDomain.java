package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "builder")
public class ReviewContentDomain {
	private Integer rbSeq;
	private String smbId;

	private String rbTitle;
	private String rbContent;

}
