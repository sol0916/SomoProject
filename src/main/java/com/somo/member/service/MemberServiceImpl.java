package com.somo.member.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.member.model.MemberDAO;
import com.somo.member.model.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	
	//가입
	@Override
	public int join(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPwCheck = request.getParameter("memPw_check");
		String memName = request.getParameter("memName");
		String memPhone = request.getParameter("memPhone");
		String memAddr1 = request.getParameter("memAddr1");
		String memAddr2 = request.getParameter("memAddr2");
		String memAddr = memAddr1 + " " + memAddr2;
		String memGender = request.getParameter("memGender");
		String memBirth = request.getParameter("memBirth");
		String memNick = request.getParameter("memNick");
		String memEmail = request.getParameter("memEmail");
		
		//싱글톤 객체(dao)
		MemberDAO dao = MemberDAO.getInstance();
		
		//아이디 중복 검사
		int resultId = dao.idCheck(memId);
		
		//닉네임 중복 검사
		int resultNick = dao.nickCheck(memNick);
		
		//비밀번호 확인
		int resultPw = memPw.equals(memPwCheck) ? 0 : 1;
		

		if(resultId==1) { //중복
			return 1;
		} else if(resultNick==1) {
			return 2;
		} else if(resultPw==1) {
			return 3;
		} else { //가입처리
			
			MemberVO vo = new MemberVO(memId, memPw, memName, memPhone, memAddr, memGender, memBirth, "user", memNick, memEmail);
			dao.join(vo);
		}
			
		return 0;
	}

	//로그인
	@Override
	public MemberVO login(HttpServletRequest request, HttpServletResponse response) {
	
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		//로그인
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.login(memId, memPw);
		
		return vo;
	}

	//정보 가져오기
	public MemberVO getInfo(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String memId = (String)session.getAttribute("user_id");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = dao.getInfo(memId);
		
		
		return vo;
	}
}