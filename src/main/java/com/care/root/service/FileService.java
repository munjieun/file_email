package com.care.root.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileService {
	//IMAGE_REPO가 파일저장소라고 생각하면 됨, 해당 위치에 파일들을 관리 하겠다.
	public static final String IMAGE_REPO = "C:/spring/image_repo";
	public void fileProcess(MultipartHttpServletRequest mul);
	public void getData(Model model);
}
