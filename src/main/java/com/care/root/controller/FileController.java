package com.care.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.care.root.service.FileService;

@Controller
public class FileController {
	@Autowired FileService fs;
	@GetMapping("form")
	public String form() {
		return "uploadForm";
	}
	@PostMapping("upload")
	public String upload(MultipartHttpServletRequest mul) {
		//form에서 multipart로 넘겨줬으므로 여기서도 multipart로 받아줘야한다.
		/*
		System.out.println(mul.getParameter("id"));
		System.out.println(mul.getParameter("name"));
		
		//파일은 아래처럼 받아서 가져와야한다. 위처럼 받으면 null
		MultipartFile file = mul.getFile("file");
		System.out.println(file.getOriginalFilename());
		*/
		fs.fileProcess(mul);
		return "redirect:form";
	}
}
