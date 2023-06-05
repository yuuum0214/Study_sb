package com.co.kr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.co.kr.domain.AskListDomain;
import com.co.kr.domain.ReviewListDomain;

@Mapper
public interface ReviewMapper {
	
	//content list
	List<ReviewListDomain> selectReviewList() throws Exception;
	
	//content insert
	void insertReview(ReviewListDomain reviewListDomain) throws Exception;

	//상세 보기
	ReviewListDomain selectReviewDetail(int rbSeq) throws Exception;
	
	//수정하기
	void updateReview(ReviewListDomain reviewListDomain) throws Exception;
		
	//삭제하기
	void deleteReview(int rbSeq) throws Exception;
	
	
	//select one file
	/*	public List<ReviewFileDomain> boardSelectOneFile(HashMap<String, Object> map);

		public void rbContentRemove(HashMap<String, Object> map);

		public void rbContentUpdate(ReviewContentDomain reviewContentDomain);

		public void contentUpload(ReviewContentDomain reviewContentDomain); */
	

	
}
