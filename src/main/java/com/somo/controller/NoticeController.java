package com.somo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.controller.*;
import com.somo.notice.model.NoticeVO;
import com.somo.notice.service.NoticeService;
import com.somo.notice.service.NoticeServiceImpl;

@WebServlet("*.board")
public class NoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//한글처리
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring( conPath.length()  );

		System.out.println(command);

		//게시글 서비스 선언
		NoticeService service = new NoticeServiceImpl();

		//글쓰기 화면에 처리
		if( command.equals("/notice/board_write.board") ) {

			request.getRequestDispatcher("board_write.jsp").forward(request, response);

			//목록 화면에 처리
		} else if(command.equals("/notice/board_list.board")) {

			//목록을 가지고 나옴
			List<NoticeVO> list = service.getList(request, response);
			request.setAttribute("list", list);

			request.getRequestDispatcher("board_list.jsp").forward(request, response);

			//등록 작업
		} else if(command.equals("/notice/registForm.board")) {

			service.regist(request, response);
			//1.forward
			//2.redirect

			response.sendRedirect("board_list.board");
			//request.getRequestDispatcher("board_list.jsp").forward(request, response);


			//상세 화면
		} else if(command.equals("/notice/board_content.board")) {
			//getContent : bno
			
			//조회수 증가
			service.hitup(request, response);
			
			NoticeVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("board_content.jsp").forward(request, response);
			
			//수정 화면
		} else if(command.equals("/notice/board_modify.board")) {
			//getContent : bno
			NoticeVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);

			request.getRequestDispatcher("board_modify.jsp").forward(request, response);


			//글 수정
		} else if(command.equals("/notice/board_update.board") ) {

			service.update(request, response);

			String ntno = request.getParameter("ntno");
			//상세페이지로 이동
			response.sendRedirect("board_content.board?ntno=" + ntno );

		
			//글 삭제
		} else if(command.equals("/notice/board_delete.board")) {
			//getContent : bno
			
			service.delete(request, response);
			
			response.sendRedirect("board_list.board");
			
	
	}

}
	
}







