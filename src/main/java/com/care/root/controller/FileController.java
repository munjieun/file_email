package com.care.root.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping("views")
	public String views(Model model) {
		fs.getData(model);
		return "result";
	}
	@GetMapping("download")
	public void download(@RequestParam("file") String fileName,
						HttpServletResponse response) throws Exception {
		//Content-disposition : 파일로 응답 하겠다.
		//attachment : 웹 브라우저로 파일을 표현하겠다.
		//fileName : 다운로드 할 이름
		response.addHeader("Content-disposition", 
				"attachment; fileName="+fileName);
		File file = new File(FileService.IMAGE_REPO + "/" + fileName);
		FileInputStream fis = new FileInputStream(file);
		//FileCopyUtils : inputstream으로 가져온 파일을 내보내줌(read, write 쓸 필요 없음)
		FileCopyUtils.copy(fis, response.getOutputStream());
	}
}
