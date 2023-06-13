package com.somo.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.hboard.model.HBoardVO;
import com.somo.member.model.MemberVO;

public interface MemberService {
	
	int join(HttpServletRequest request, HttpServletResponse response);
	MemberVO login(HttpServletRequest request, HttpServletResponse response);
	MemberVO getInfo(HttpServletRequest request, HttpServletResponse response);
	int updateInfo(HttpServletRequest request, HttpServletResponse response);
	int deleteInfo(HttpServletRequest request, HttpServletResponse response);
	List<HBoardVO> findMyBoard(HttpServletRequest request, HttpServletResponse response);

}
