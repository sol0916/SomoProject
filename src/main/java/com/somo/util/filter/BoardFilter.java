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

@WebFilter({
	"/member/member_modify.mem",
	"/member/member_myBoardList.mem"
})
public class BoardFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;

		HttpSession session = req.getSession();


		String memId = (String)session.getAttribute("memId");

		String path = req.getContextPath() + "/index.jsp";

		if(memId == null) {

			//res.sendRedirect(path);
			res.setContentType("text/html; charset=UTF-8;");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('허용하지 않는 접근입니다.');");
			out.println("location.href='" + path + "';");
			out.println("</script>");
			return;
		}

		chain.doFilter(request, response);
	}
}