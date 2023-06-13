package com.somo.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.member.model.MemberVO;

public interface MemberService {
	
	int join(HttpServletRequest request, HttpServletResponse response);
	MemberVO login(HttpServletRequest request, HttpServletResponse response);
	MemberVO getInfo(HttpServletRequest request, HttpServletResponse response);
	int updateInfo(HttpServletRequest request, HttpServletResponse response);

}
