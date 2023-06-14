package com.somo.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.hboard.model.HBoardDAO;
import com.somo.hboard.model.HBoardVO;
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
	
	//전체 정보 가져오기
	@Override
	public List<MemberVO> getMemList(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> list = dao.getMemList();
		
		return list;
	}
	
	//주소 나누기
	public String[] splitAddr(String memAddr) {
				
		String[] addr = memAddr.split(" ");
		
		String memAddr1 = addr[0];
		String memAddr2 = addr[1];
		
		return new String[] {memAddr1, memAddr2};
	}

	//회원정보 수정하기
	@Override
	public int updateInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPhone = request.getParameter("memPhone");
		String memAddr1 = request.getParameter("memAddr1");
		String memAddr2 = request.getParameter("memAddr2");
		String memAddr = memAddr1 + " " + memAddr2;
		String memGender = request.getParameter("memGender");
		String memBirth = request.getParameter("memBirth");
		String memNick = request.getParameter("memNick");
		String memEmail = request.getParameter("memEmail");
		
		MemberVO vo = new MemberVO(memId, null, null, memPhone, memAddr, memGender, memBirth, null, memNick, memEmail);
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.updateInfo(vo);
		
		return result;
	}

	//회원 탈퇴
	@Override
	public int deleteInfo(HttpServletRequest request, HttpServletResponse response) {

		String memId = (String)request.getSession().getAttribute("user_id");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.deleteInfo(memId);
				
		return result;
	}
	
	//작성 글 목록
	@Override
	public List<HBoardVO> findMyBoard(HttpServletRequest request, HttpServletResponse response) {
		
		MemberDAO dao = MemberDAO.getInstance();
		String memId = (String)request.getSession().getAttribute("user_id");
		List<HBoardVO> list = dao.findMyBoard(memId);
					
		return list;
	}
	
	//비밀번호 확인
	public int pwCheck(HttpServletRequest request, HttpServletResponse response) {

		String memPw = request.getParameter("memPw");
		String id  = (String)request.getSession().getAttribute("user_id");	
		MemberDAO dao = MemberDAO.getInstance();
		
		int resultPw = dao.pwCheck(id,memPw);


		return resultPw;
	}
	
}
