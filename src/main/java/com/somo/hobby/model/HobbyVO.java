package com.somo.hobby.model;

public class HobbyVO {
	private int hno;
	private String hname;
	
	public HobbyVO() {
		// TODO Auto-generated constructor stub
	}

	public HobbyVO(int hno, String hname) {
		super();
		this.hno = hno;
		this.hname = hname;
	}

	public int getHno() {
		return hno;
	}

	public void setHno(int hno) {
		this.hno = hno;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}
	
	
}
