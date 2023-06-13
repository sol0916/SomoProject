package com.somo.hboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.hboard.model.HBoardVO;

public interface HBoardService {
	
	void regist(HttpServletRequest request, HttpServletResponse response);
	List<HBoardVO> getList(HttpServletRequest request, HttpServletResponse response);
	HBoardVO getContent(HttpServletRequest request, HttpServletResponse response);
	void update(HttpServletRequest request, HttpServletResponse response);
	List<HBoardVO> gethnoList(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
}
