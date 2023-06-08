package com.co.kr.domain;

import lombok.Data;

@Data
public class AskFileDomain {

	private Integer ibSeq;
	private String smbId;
	private String ibOrigFile;
	private String ibFilePath;
	private long ibFileSize;	

}
