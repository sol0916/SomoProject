package com.somo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.somo.reply.model.ReplyVO;
import com.somo.reply.service.ReplyService;
import com.somo.reply.service.ReplyServiceImpl;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		System.out.println(command);
		
		HttpSession session = request.getSession();
		ReplyService service = new ReplyServiceImpl();
		//댓글 등록
		if(command.equals("/hboard/reply_insert.reply")) {
			
			service.insertReply(request, response);
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			response.sendRedirect(request.getContextPath()+"/hboard/hboard_content.hboard?boardNum="+boardNum);
		//댓글 수정
		} else if(command.equals("/hboard/reply_modify.reply")) {
			
			ReplyVO rpvo = service.getoneReply(request, response);
			request.setAttribute("replymodify", 1);
			request.setAttribute("rpvo", rpvo);
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			request.getRequestDispatcher("/hboard/hboard_content.hboard?boardNum="+boardNum).forward(request, response);
		//댓글 수정 과정 
		} else if(command.equals("/hboard/reply_update.reply")) {
			
			service.updateReply(request, response);
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			response.sendRedirect(request.getContextPath()+"/hboard/hboard_content.hboard?boardNum="+boardNum);
		//댓글 삭제
		}else if(command.equals("/hboard/reply_delete.reply")) {
			service.deleteReply(request, response);
			int boardNum = Integer.parseInt(request.getParameter("boardNum"));
			response.sendRedirect(request.getContextPath()+"/hboard/hboard_content.hboard?boardNum="+boardNum);
			
			
		}
		
		
	}

}
