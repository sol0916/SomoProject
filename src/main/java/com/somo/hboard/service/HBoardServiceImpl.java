package com.somo.hboard.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.somo.hboard.model.HBoardDAO;
import com.somo.hboard.model.HBoardVO;
import com.somo.hobby.model.HobbyDAO;
import com.somo.hobby.model.HobbyVO;

public class HBoardServiceImpl implements HBoardService {

	@Override
	public void regist(HttpServletRequest request, HttpServletResponse response) {
		
		String savePath = "/boardimg";
		String realPath = request.getServletContext().getRealPath(savePath);
		int limitSize = 20*1024*1024;
		try {
			MultipartRequest multi = new MultipartRequest(request, realPath, limitSize, "utf-8",new DefaultFileRenamePolicy());
			HobbyDAO hdao = HobbyDAO.getInstance();
			int hno = hdao.gethno(multi.getParameter("hname"));
			String memid = (String)request.getSession().getAttribute("user_id");		
			String bowriter = (String)request.getSession().getAttribute("user_nick");
			String boTitle = multi.getParameter("boTitle");
			String boContent = multi.getParameter("boContent");
			String filename = multi.getFilesystemName("img");
			String originName = multi.getOriginalFileName("img");
			
			
			HBoardVO vo = new HBoardVO(0, memid, hno, bowriter, boTitle, boContent, 0,null, filename);
			HBoardDAO dao = HBoardDAO.getInstance();
			dao.regist(vo);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("등록안됨");
		}
		
		/*
		HobbyDAO hdao = HobbyDAO.getInstance();
		int hno = hdao.gethno(request.getParameter("hname"));
		String memid = (String)request.getSession().getAttribute("user_id");		
		String bowriter = (String)request.getSession().getAttribute("user_nick");
		String boTitle = request.getParameter("boTitle");
		String boContent = request.getParameter("boContent");
		
		
		HBoardVO vo = new HBoardVO(0, memid, hno, bowriter, boTitle, boContent, 0, null);
		HBoardDAO dao = HBoardDAO.getInstance();
		dao.regist(vo);
		 */
	}

	@Override
	public List<HBoardVO> getList(HttpServletRequest request, HttpServletResponse response) {

		HBoardDAO dao = HBoardDAO.getInstance();
		List<HBoardVO> list = dao.getList();
		
		return list;
	}

	@Override
	public HBoardVO getContent(HttpServletRequest request, HttpServletResponse response) {
		
		String boardNum = request.getParameter("boardNum");
		
		HBoardDAO dao = HBoardDAO.getInstance();
		HBoardVO vo = dao.getContent(boardNum);
		
		return vo;
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {

		String boardNum = request.getParameter("boardNum");
		String boTitle = request.getParameter("boTitle");
		String boContent = request.getParameter("boContent");
		
		HBoardDAO dao = HBoardDAO.getInstance();
		dao.update(boardNum, boTitle, boContent);
		
	}

	@Override
	public List<HBoardVO> gethnoList(HttpServletRequest request, HttpServletResponse response) {
		int hno = Integer.parseInt(request.getParameter("hno"));
		HBoardDAO dao = HBoardDAO.getInstance();
		List<HBoardVO> list = dao.getHnoList(hno);
		
		return list;
	}

	@Override
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		String boardNum = request.getParameter("boardNum");
	      
	      HBoardDAO dao = HBoardDAO.getInstance();
	      dao.delete(boardNum);
	}

	@Override
	public List<HobbyVO> getHobby(HttpServletRequest request, HttpServletResponse response) {
		 HobbyDAO dao = HobbyDAO.getInstance();
		 
		List<HobbyVO> list =  dao.getHobby();
		System.out.println("imple"+list.get(0).getHname());
		return dao.getHobby();
	}

	@Override
	public void hitup(HttpServletRequest request, HttpServletResponse response) {
		HBoardDAO dao = HBoardDAO.getInstance();
		dao.hitup(request.getParameter("boardNum"));
		
	}

	@Override
	public List<HBoardVO> search(HttpServletRequest request, HttpServletResponse response) {
		String str = request.getParameter("search");
		HBoardDAO dao = HBoardDAO.getInstance();
		
		return dao.searchBoard(str);
	}

	

			
	
}
