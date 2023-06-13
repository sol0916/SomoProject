package com.somo.reply.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somo.reply.model.ReplyVO;

public interface ReplyService {
	
	int insertReply(HttpServletRequest request, HttpServletResponse response);
	int updateReply(HttpServletRequest request, HttpServletResponse response);
	int deleteReply(HttpServletRequest request, HttpServletResponse response);
	List<ReplyVO> getReply(HttpServletRequest request, HttpServletResponse response);
	ReplyVO getoneReply(HttpServletRequest request, HttpServletResponse response);
}
