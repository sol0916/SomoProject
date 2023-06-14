package com.somo.util.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.hboard.model.HBoardDAO;
import com.somo.hboard.model.HBoardVO;
import com.somo.hboard.service.HBoardService;
import com.somo.hboard.service.HBoardServiceImpl;
import com.somo.member.model.MemberDAO;
import com.somo.member.model.MemberVO;
import com.somo.member.service.MemberService;
import com.somo.member.service.MemberServiceImpl;
import com.somo.reply.model.ReplyVO;
import com.somo.reply.service.ReplyService;
import com.somo.reply.service.ReplyServiceImpl;

@WebFilter({							 //댓글입력
		   "/hboard/reply_modify.reply", //댓글수정
		   "/hboard/reply_update.reply",
		   "/hboard/reply_delete.reply"//댓글 
		   
			})
public class MemberFilter implements Filter {
       
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		MemberService mService = new MemberServiceImpl();
		HBoardService hService = new HBoardServiceImpl();
		ReplyService rService = new ReplyServiceImpl();
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO mvo = mService.getInfo(req, res);
		
		HBoardVO vo = hService.getContent(req, res);
		request.setAttribute("vo", vo);
		
		ReplyVO rvo = rService.getoneReply(req, res);
		request.setAttribute("rvo", rvo);
		
		HBoardDAO hdao = HBoardDAO.getInstance();
		List<HBoardVO> hblist = hdao.getList();
		
		List<MemberVO> mlist = dao.getMemList();
		
		//세션 얻기
		HttpSession session = req.getSession();
		
		
		String memId = (String)session.getAttribute("user_id"); // 세션안됌 멤버 목록으로 해야됨.
		// List<MemberVO> list = new ArrayList<>();
		
		String path = req.getContextPath() + "/hboard/hboard_content.hboard?boardNum=" + vo.getBoardNum();
		
		res.setContentType("text/html; charset=UTF-8;");
		PrintWriter out =  res.getWriter();
		
		//로그인 안됨
		if(memId.equals("admin")) {
			out.println("<script>");
			out.println("location.href='" + path + "';");
			out.println("</script>");
			
		} else if(!rvo.getrWriter().equals(memId)) {
			
			out.println("<script>");
			out.println("alert('타인은 수정 및 삭제가 불가능합니다.');");
			out.println("location.href='" + path + "';");
			out.println("</script>");
			
			return;
		}	
		
		
		
		chain.doFilter(request, response);
	}
}
