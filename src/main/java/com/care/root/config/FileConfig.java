package com.care.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

//@Configuration: 설정에 관련된 어노테이션
//내부에 빈 어노테이션이 있는 메소드들을 빈으로 만들어주는 어노테이션
@Configuration
public class FileConfig {
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		//이 빈이 꼭 있어야 파일업로드 가능
		//메소드 이름은 꼭 multipartResolver라고 지정해야 된다.
		CommonsMultipartResolver mr = new CommonsMultipartResolver();
		
		mr.setMaxUploadSize(52428800); //50MB, 업로드 사이즈 지정
		mr.setDefaultEncoding("utf-8");
		
		return mr;
	}
	/*
	어노테이션 방식
	@Bean
	public ShoesDTO test() {
		return new ShoesDTO();
	}
	xml 방식
	<beans:bean id="test" class="com.care.root.dto.ShoesDTO"/>
	*/
}
