package com.somo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.hboard.model.HBoardVO;
import com.somo.member.model.MemberVO;
import com.somo.member.service.MemberService;
import com.somo.member.service.MemberServiceImpl;

@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		//경로
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
	
		
		//service 객체
		MemberService service = new MemberServiceImpl();
		
		//세션
		HttpSession session = request.getSession();
		
		
		//회원가입 페이지 이동
		if(command.equals("/member/member_join.mem")) {
			
			request.getRequestDispatcher("member_join.jsp").forward(request, response);
		
		//회원가입 요청
		} else if(command.equals("/member/joinForm.mem")) {
			
			//가입
			int result = service.join(request, response);
			
			if(result==1) { //아이디 중복
								
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디가 중복입니다');");
				out.println("location.href='member_join.mem';");
				out.println("</script>");
				
				//request.getRequestDispatcher("member_join.jsp").forward(request, response);
								
			} else if(result==2) { //닉네임 중복
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('닉네임이 중복입니다');");
				out.println("location.href='member_join.mem';");
				out.println("</script>");
						
			} else if(result==3) {
				
				request.setAttribute("msg", "비밀번호가 다릅니다");
				request.getRequestDispatcher("member_join.jsp").forward(request, response);
				
			} else { //가입성공
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('가입되셨습니다. 로그인해주십시오');");
				out.println("location.href='member_login.mem';");
				out.println("</script>");
				
				response.sendRedirect("member_login.mem");
			}
		
		//로그인 페이지 이동
		} else if(command.equals("/member/member_login.mem")) {
			
			request.getRequestDispatcher("member_login.jsp").forward(request, response);
		
		//로그인 	
		} else if(command.equals("/member/loginForm.mem")) {
			
			MemberVO vo = service.login(request, response);
			
			if(vo==null) { //로그인 실패
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('아이디와 비밀번호를 확인해주십시오');");
				out.println("location.href='member_login.mem';");
				out.println("</script>");
				
			} else { //로그인 성공
				
				//세션에 회원정보 저장
				session.setAttribute("user_id", vo.getMemId());
				session.setAttribute("user_nick", vo.getMemNick());
				session.setAttribute("user_name", vo.getMemName());
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('환영합니다');");
				out.println("location.href='member_mypage.mem';");
				out.println("</script>");
				
				response.sendRedirect("member_mypage.mem");
				
			}
		
		//로그아웃 - 인증수단을 삭제	
		} else if(command.equals("/member/member_logout.mem")) {
			
			session.invalidate();
			response.sendRedirect("member_login.mem");
			
			
		//마이페이지
		} else if(command.equals("/member/member_mypage.mem")) {
			
			MemberVO vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("member_mypage.jsp").forward(request, response);
		
		//회원정보 수정 페이지 이동
		} else if(command.equals("/member/member_modify.mem")) {
			
			MemberVO vo = service.getInfo(request, response);
			request.setAttribute("vo", vo);
			
			MemberServiceImpl si = new MemberServiceImpl();
			String[] addr = si.splitAddr(vo.getMemAddr());
			String memAddr1 = addr[0];
			String memAddr2 = addr[1];
			
			request.setAttribute("memAddr1", memAddr1);
			request.setAttribute("memAddr2", memAddr2);
			
			request.getRequestDispatcher("member_modify.jsp").forward(request, response);
		
		//회원정보 수정
		} else if(command.equals("/member/member_update.mem")) {
			
			int result = service.updateInfo(request, response);
			
			if(result==1) { //성공
				
				String memNick = request.getParameter("memNick");
				session.setAttribute("user_Nick", memNick);
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정되었습니다');");
				out.println("location.href='member_mypage.mem';");
				out.println("</script>");
				
			} else {
				
				response.sendRedirect("member_modify.mem");
			}
		
		//회원 탈퇴
		} else if(command.equals("/member/member_delete.mem")) {
			
			int result = service.deleteInfo(request, response);
			
			if(result==1) {
				
				//out객체를 이용한 메시지 전달
				response.setContentType("text/html; charset=UTF-8;");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('탈퇴되셨습니다. 이용해주셔서 감사합니다.');");
				out.println("location.href='../index.jsp';");
				out.println("</script>");
				
			} else {
							
				response.sendRedirect("member_mypage.mem");
				
			}
				
		//내가 작성한 글 보기	
		} else if(command.equals("/member/member_myBoardList.mem")) {
			
			List<HBoardVO> list = service.findMyBoard(request, response);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("member_myBoardList.jsp").forward(request, response);
			
		}
		
	}

}
