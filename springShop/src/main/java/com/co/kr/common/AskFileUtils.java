package com.co.kr.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.co.kr.domain.AskFileDomain;

@Component
public class AskFileUtils {

	public List<AskFileDomain> parseFileInfo(Integer ibSeq, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		if(ObjectUtils.isEmpty(multipartHttpServletRequest)) {
			return null;
		}
		
		//파일 업로드용 폴더 생성
		List<AskFileDomain> fileList = new ArrayList<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
		ZonedDateTime current = ZonedDateTime.now();
		String path = "src/main/resources/static/askimages";   //저장경로
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
		String newFileName, originalFileExtension, contentType;
		
		while(iterator.hasNext()) {
			List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
			//파일 형식 확인 및 이미지 확장자 지정
			for(MultipartFile multipartFile : list) {
				if(!multipartFile.isEmpty()) {
					contentType = multipartFile.getContentType();
					if(ObjectUtils.isEmpty(contentType)) {
						break;
					} else {
						if(contentType.contains("image/jpeg")) {
							originalFileExtension = ".jpg";
						} else if(contentType.contains("image/png")) {
							originalFileExtension = ".png";
						} else if(contentType.contains("image/gif")) {
							originalFileExtension = ".gif";
						} else {
							break;
						}
					} 
					
					//서버에 저장될 파일명
					newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
					
					//DB에 저장
					AskFileDomain askFileDomain = new AskFileDomain();
					askFileDomain.setIbSeq(ibSeq);
					askFileDomain.setIbOrigFile(multipartFile.getOriginalFilename());
					askFileDomain.setIbFilePath(path + "/" + newFileName);
					askFileDomain.setIbFileSize(multipartFile.getSize());
					fileList.add(askFileDomain);


					//업로드된 파일 저장
					file = new File(path + "/" + newFileName);
					multipartFile.transferTo(file);
				}
			}
		}
		return fileList;
	}
}
