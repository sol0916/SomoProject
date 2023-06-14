package com.somo.util.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.member.model.MemberVO;
import com.somo.member.service.MemberService;
import com.somo.member.service.MemberServiceImpl;

@WebFilter({							 //댓글입력
		   "/hboard/reply_modify.reply", //댓글수정
		   "/hboard/reply_update.reply", //댓글 
		   
			})
public class MemberFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		MemberService mService = new MemberServiceImpl();
		
		MemberVO vo = mService.getInfo(req, res);
		
		//세션 얻기
		HttpSession session = req.getSession();
		
		String memId = (String)session.getAttribute(vo.getMemId()); // 세션안됌 멤버 목록으로 해야됨.
		// List<MemberVO> list = new ArrayList<>();
		
		String path = req.getContextPath() + "/member/member_login.mem";
		
		//로그인 안됨
		if(memId == null) {
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter out =  res.getWriter();
			out.println("<script>");
			out.println("alert('로그인이 필요한 서비스입니다.');");
			out.println("location.href='" + path + "';");
			out.println("</script>");
			
			return;
		}	
		
		chain.doFilter(request, response);
	}
}
