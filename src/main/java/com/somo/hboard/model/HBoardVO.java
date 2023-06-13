package com.somo.hboard.model;

import java.sql.Timestamp;

public class HBoardVO {
	
	private int boardNum; //게시글 번호
	private String memId; //아이디
	private int hNo; // 취미번호
	private String boWriter; // 작성자
	private String boTitle; // 제목
	private String boContent; // 내용
	private int boHit;
	private Timestamp boRegdate; 
	
	//생성자 2개
	public HBoardVO() {

	}

	public HBoardVO(int boardNum, String memId, int hNo, String boWriter, String boTitle, String boContent,
			int boHit, Timestamp boRegdate) {
		super();
		this.boardNum = boardNum;
		this.memId = memId;
		this.hNo = hNo;
		this.boWriter = boWriter;
		this.boTitle = boTitle;
		this.boContent = boContent;
		this.boHit = boHit;
		this.boRegdate = boRegdate;
	}

	
	//getter,setter
	
	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int gethNo() {
		return hNo;
	}

	public void sethNo(int hNo) {
		this.hNo = hNo;
	}

	public String getBoWriter() {
		return boWriter;
	}

	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}

	public String getBoTitle() {
		return boTitle;
	}

	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}

	public String getBoContent() {
		return boContent;
	}

	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}

	public int getBoHit() {
		return boHit;
	}

	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}

	public Timestamp getBoRegdate() {
		return boRegdate;
	}

	public void setBoRegdate(Timestamp boRegdate) {
		this.boRegdate = boRegdate;
	}

	
	
	

}
