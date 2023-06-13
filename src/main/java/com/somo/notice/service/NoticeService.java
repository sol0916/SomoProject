package com.somo.notice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.hboard.model.HBoardVO;
import com.somo.notice.model.NoticeVO;

public interface NoticeService {
	//추상메서드
	void regist(HttpServletRequest request, HttpServletResponse response); //등록기능
	List<NoticeVO> getList(HttpServletRequest request, HttpServletResponse response);
	NoticeVO getContent(HttpServletRequest request, HttpServletResponse response);//상세화면
	void update(HttpServletRequest request, HttpServletResponse response);
	void hitup(HttpServletRequest request, HttpServletResponse response);
	void delete(HttpServletRequest request, HttpServletResponse response);
	
}