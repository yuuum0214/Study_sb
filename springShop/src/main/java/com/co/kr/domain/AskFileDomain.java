package com.co.kr.domain;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "builder")
public class AskFileDomain {

	private Integer ibSeq;
	private String smbId;
	private String ibOrigFile;
	private String ibNewFile;
	private String ibFilePath;
	private String ibFileSize;

}
