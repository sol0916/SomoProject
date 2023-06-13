package com.somo.reply.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.reply.model.ReplyDAO;
import com.somo.reply.model.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	@Override
	public int insertReply(HttpServletRequest request, HttpServletResponse response) {
		String rcontent = request.getParameter("rContent");
		int boardnum = Integer.parseInt(request.getParameter("boardNum"));
		String writer = (String)request.getSession().getAttribute("user_id");
		ReplyVO vo = new ReplyVO(0, writer, rcontent, null, boardnum);
		ReplyDAO dao = ReplyDAO.getInstance();
		
		return dao.insertReply(vo);
	}

	@Override
	public int updateReply(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ReplyVO> getReply(HttpServletRequest request, HttpServletResponse response) {
		ReplyDAO dao = ReplyDAO.getInstance();
		int boardnum = Integer.parseInt(request.getParameter("boardNum"));
		
		
		return dao.getReply(boardnum);
	}

	
}
