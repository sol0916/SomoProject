package com.somo.hobby.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HobbyDAO {
	private static HobbyDAO instance = new HobbyDAO();

	private HobbyDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static HobbyDAO getInstance() {
		return instance;
	}

	private String url = "jdbc:oracle:thin:@172.30.1.95:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";
	
	public List<HobbyVO> getHobby(){
		List<HobbyVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from hobby";
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {
				HobbyVO vo = new HobbyVO(rs.getInt(1), rs.getString(2));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getHobby");
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
		
		return list;
	}
	
	public int gethno(String hname) {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select * from hobby where hname=?";
	int hno;
	
	try {
		conn = DriverManager.getConnection(url, uid, upw);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, hname);
		rs= pstmt.executeQuery();
		
		if(rs.next()) {
			hno = rs.getInt(1);
			return hno;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("getHobby");
	} finally {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	
	
	
		return -1;
	}	
	
	
}
