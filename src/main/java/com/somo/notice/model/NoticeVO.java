package com.somo.notice.model;

import java.sql.Timestamp;

public class NoticeVO {

	private int ntno;
	private String nttitle;
	private String ntcontent;
	private Timestamp ntregdate;
	private int nthit;
	private String memid;
	
	public NoticeVO() {
		
	}

	public NoticeVO(int ntno, String nttitle, String ntcontent, Timestamp ntregdate, int nthit, String memid) {
		super();
		this.ntno = ntno;
		this.nttitle = nttitle;
		this.ntcontent = ntcontent;
		this.ntregdate = ntregdate;
		this.nthit = nthit;
		this.memid = memid;
	}

	public int getNtno() {
		return ntno;
	}

	public void setNtno(int ntno) {
		this.ntno = ntno;
	}

	

	public String getNttitle() {
		return nttitle;
	}

	public void setNttitle(String nttitle) {
		this.nttitle = nttitle;
	}

	public String getNtcontent() {
		return ntcontent;
	}

	public void setNtcontent(String ntcontent) {
		this.ntcontent = ntcontent;
	}

	public Timestamp getNtregdate() {
		return ntregdate;
	}

	public void setNtregdate(Timestamp ntregdate) {
		this.ntregdate = ntregdate;
	}

	public int getNthit() {
		return nthit;
	}

	public void setNthit(int nthit) {
		this.nthit = nthit;
	}

	public String getMemid() {
		return memid;
	}

	public void setMemid(String memid) {
		this.memid = memid;
	}
	
}
	
