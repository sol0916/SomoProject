package com.somo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.hboard.model.HBoardVO;
import com.somo.hboard.service.HBoardService;
import com.somo.hboard.service.HBoardServiceImpl;

@WebServlet("*.hboard")
public class HBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HBoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
		
	}

	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
		
		//게시글 서비스 선언
		HBoardService service = new HBoardServiceImpl();
		
		//1. 글쓰기 화면 처리
		if(command.equals("/hboard/hboard_write.hboard")) {
			
			request.getRequestDispatcher("hboard_write.jsp").forward(request, response);
	
			//2. 목록화면에 처리
		} else if (command.equals("/hboard/hboard_list.hboard")) {
			
				List<HBoardVO> list = service.getList(request, response);
				request.setAttribute("list", list);// 키값
			
			request.getRequestDispatcher("hboard_list.jsp").forward(request, response);
		
			//3. 등록작업
		} else if (command.equals("/hboard/registForm.hboard")) {
			
			service.regist(request, response);
			//1. forward 
			response.sendRedirect("hboard_list.hboard");
		
			//상세 화면
		
		} else if (command.equals("/hboard/hboard_content.hboard")) {
			
			HBoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("hboard_content.jsp").forward(request, response);
			
		//수정화면
			
		} else if (command.equals("/hboard/hboard_modify.hboard")) {
			
			HBoardVO vo = service.getContent(request, response);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher("hboard_modify.jsp").forward(request, response);
		
		}else if (command.equals("/hboard/hno_board.hboard")) {
			
			List<HBoardVO> list = service.gethnoList(request, response);
			request.setAttribute("list", list);
			request.getRequestDispatcher("hboard_list.jsp").forward(request, response);
		
		}else if (command.equals("/hboard/hboard_req.hboard")) {
			
			request.getRequestDispatcher("hboard_req.jsp").forward(request, response);
		
		}
		
		
		
		
		
		
	}
	
}
