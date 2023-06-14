package com.somo.reply.model;

import java.sql.Timestamp;

public class ReplyVO {
	
	private int rNo;
	private String rWriter;
	private String rContent;
	private Timestamp rDate;
	private	int boardNum;
	private String rnick;
	
	
	public String getRnick() {
		return rnick;
	}


	public void setRnick(String rnick) {
		this.rnick = rnick;
	}


	//생성자 2개
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}


	public ReplyVO(int rNo, String rWriter, String rContent, Timestamp rDate, int boardNum) {
		super();
		this.rNo = rNo;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rDate = rDate;
		this.boardNum = boardNum;
	}
	
	

	
	public ReplyVO(int rNo, String rWriter, String rContent, Timestamp rDate, int boardNum, String rnick) {
		super();
		this.rNo = rNo;
		this.rWriter = rWriter;
		this.rContent = rContent;
		this.rDate = rDate;
		this.boardNum = boardNum;
		this.rnick = rnick;
	}


	//getter, setter

	public int getrNo() {
		return rNo;
	}


	public void setrNo(int rNo) {
		this.rNo = rNo;
	}


	public String getrWriter() {
		return rWriter;
	}


	public void setrWriter(String rWriter) {
		this.rWriter = rWriter;
	}


	public String getrContent() {
		return rContent;
	}


	public void setrContent(String rContent) {
		this.rContent = rContent;
	}


	public Timestamp getrDate() {
		return rDate;
	}


	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}


	public int getBoardNum() {
		return boardNum;
	}


	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	
	
}
