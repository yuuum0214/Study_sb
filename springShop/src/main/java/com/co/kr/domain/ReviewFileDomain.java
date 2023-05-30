package com.co.kr.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "builder")
public class ReviewFileDomain {
	
	private Integer rbSeq;
	private String smbId;
	
	private String rbOrigFile;
	private String rbNewFile; //동일 이름 업로드 될 경우
	private String rbFilePath;
	private Integer rbFileSize;

}
