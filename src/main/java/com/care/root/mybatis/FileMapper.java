package com.care.root.mybatis;

import java.util.List;

import com.care.root.dto.ShoesDTO;

public interface FileMapper {
	public void saveData(ShoesDTO dto);
	//보통 부모형태로 받음, arraylist 써도 상관 없음
	public List<ShoesDTO> getData();
}
