package com.co.kr.controller;

public class FileListController {
	
	/*	@Autowired
	private ReviewService reviewService;
	
	@PostMapping(value = "/review/insertReview")
	public ModelAndView rbUpload(FileListVO fileListVO, MultipartHttpServletRequest request, HttpServletRequest httpReq) throws IOException, ParseException {
		
		ModelAndView mav = new ModelAndView();
		int rbSeq = reviewService.fileProcess(fileListVO, request, httpReq);
		fileListVO.setContent("");
		fileListVO.setTitle("");
		
		mav = rbSelectOneCall(fileListVO, String.valueOf(rbSeq), request);
		mav.setViewName("/review");
		return mav;
	}
		
		
		
		
		
		
		public ModelAndView rbSelectOneCall(@ModelAttribute("fileListVO") FileListVO fileListVO, String rbSeq, HttpServletRequest request) {
			ModelAndView mav = new ModelAndView();
			HashMap<String, Object> map = new HashMap<String, Object>();
			HttpSession session = request.getSession();
			
			map.put("rbSeq", Integer.parseInt(rbSeq));
			ReviewListDomain reviewListDomain =reviewService.boardSelectOne(map);
			System.out.println("reviewListDomain"+reviewListDomain);
			List<ReviewFileDomain> fileList =  reviewService.boardSelectOneFile(map);
			
			for (ReviewFileDomain list : fileList) {
				String path = list.getRbFilePath().replaceAll("\\\\", "/");
				list.setRbFilePath(path);
			}
			mav.addObject("detail", reviewListDomain);
			mav.addObject("files", fileList);

			//삭제시 사용할 용도
			session.setAttribute("files", fileList);

			
			return mav;
		}*/

}
