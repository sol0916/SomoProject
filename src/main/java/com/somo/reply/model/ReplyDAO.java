package com.somo.reply.model;

public class ReplyDAO {
	
	private static ReplyDAO instance = new ReplyDAO();
	
	private ReplyDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ReplyDAO getInstance() {
		return instance;
	}
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";
	
	
	//댓글 등록하기
	
	
	//댓글 수정하기
	
	
	//댓글 삭제하기
	
	

}
