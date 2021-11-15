package com.care.root.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.dto.ShoesDTO;
import com.care.root.mybatis.FileMapper;

@Service
public class FileServiceImpl implements FileService{
	@Autowired FileMapper fm;
	
	public void fileProcess(MultipartHttpServletRequest mul) {
		ShoesDTO dto = new ShoesDTO();
		dto.setId(mul.getParameter("id"));
		dto.setName(mul.getParameter("name"));
		
		MultipartFile file = mul.getFile("file");
		if(file.getSize() != 0) { //if(!file.isEmpty())
			SimpleDateFormat fo = new SimpleDateFormat("yyyyMMddHHmmss-");
			Calendar calendar = Calendar.getInstance();
			//sysFileName => 20211115173532-파일이름
			String sysFileName = fo.format(calendar.getTime());
			sysFileName += file.getOriginalFilename();
			//해당 경로에 선택한 파일 저장
			//경로+파일명 => C:/spring/image_repo/선택파일명.확장자
			File saveFile = new File(IMAGE_REPO + "/" + sysFileName);
			dto.setImgName(sysFileName);
			try {
				file.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}else {
			dto.setImgName("nan");
		}
		fm.saveData(dto);
	}
	public void getData(Model model) {
		model.addAttribute("list", fm.getData());
	}
}
