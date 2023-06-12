package com.somo.member.model;

public class MemberVO {
	
	private String memId;
	private String memPw;
	private String memName;
	private String memPhone;
	private String memAddr;
	private String memGender;
	private String memBirth;
	private String memType;
	private String memNick;
	private String memEmail;

	//생성자
	public MemberVO() {
	}

	
	public MemberVO(String memId, String memPw, String memName, String memPhone, String memAddr, String memGender,
			String memBirth, String memType, String memNick, String memEmail) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.memPhone = memPhone;
		this.memAddr = memAddr;
		this.memGender = memGender;
		this.memBirth = memBirth;
		this.memType = memType;
		this.memNick = memNick;
		this.memEmail = memEmail;
	}



	//getter, setter
	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemBirth() {
		return memBirth;
	}

	public void setMemBirth(String memBirth) {
		this.memBirth = memBirth;
	}

	public String getMemType() {
		return memType;
	}

	public void setMemType(String memType) {
		this.memType = memType;
	}

	public String getMemNick() {
		return memNick;
	}

	public void setMemNick(String memNick) {
		this.memNick = memNick;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}


	public String getMemGender() {
		return memGender;
	}


	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	
	

}
