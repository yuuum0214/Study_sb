package com.co.kr.domain;

import lombok.Data;

@Data
public class ReviewFileDomain {
	
	private int seq;
	private int rbSeq;
	private Integer smbId;
	private String rbOrigFile;
	private String rbFilePath;
	private Long rbFileSize;

}
