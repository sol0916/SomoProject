package com.somo.notice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement;

import com.somo.notice.model.NoticeVO;
import com.somo.notice.model.NoticeDAO;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		//title, writer, content
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		NoticeDAO dao =	NoticeDAO.getInstance();
		dao.regist(writer, title, content);
	}

	@Override
	public NoticeVO getContent(HttpServletRequest request, HttpServletResponse response) {

		String ntno = request.getParameter("ntno");


		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = dao.getContent(ntno);

		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		String ntno = request.getParameter("ntno");
		String title = request.getParameter("title");
		String content= request.getParameter("content");

		NoticeDAO dao = NoticeDAO.getInstance();
		dao.update(ntno,title,content);

	}

	@Override
	public List<NoticeVO> getList(HttpServletRequest request, HttpServletResponse response) {
		NoticeDAO dao = NoticeDAO.getInstance();
		List<NoticeVO> list = dao.getList();
		return list;
	}

	@Override
	public void hitup(HttpServletRequest request, HttpServletResponse response) {

		NoticeDAO dao = NoticeDAO.getInstance();
		String ntno = request.getParameter("ntno");
		dao.hitup(ntno);


	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {

		String ntno = request.getParameter("ntno");

		NoticeDAO dao = NoticeDAO.getInstance();
		dao.delete(ntno);

	}

	


}




