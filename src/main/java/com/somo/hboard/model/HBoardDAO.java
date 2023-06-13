package com.somo.hboard.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class HBoardDAO {

	//싱글톤 객체 형성
	private static HBoardDAO instance = new HBoardDAO();

	//생성자 제한
	private HBoardDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static HBoardDAO getInstance() {
		return instance;
	}

	//데이터베이스 연결주소
	//오라클 커넥터
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";


	//글 등록하기 회원외에 등록는 작성불가
	public void regist(String boTitle, String boContent) {

		String sql = "insert into hboard(boardnum, botitle, bocontent) values(BOARDNUM_SEQ.NEXTVAL, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boTitle);
			pstmt.setString(2, boContent);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//목록조회
	public List<HBoardVO> getList() {

		List<HBoardVO> list = new ArrayList<>();

		String sql = "SELECT * FROM HBOARD ORDER BY BOARDNUM DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			int boardNum = rs.getInt("boardNum");
			String memId = rs.getString("memId");
			int hNo = rs.getInt("hNo");
			String boWriter = rs.getString("boWriter");
			String boTitle = rs.getString("boTitle");
			String boContent = rs.getString("boContent");
			int boHit = rs.getInt("boHit");
			Timestamp boRegdate = rs.getTimestamp("boRegdate");
			
			HBoardVO vo = new HBoardVO(boardNum, memId, hNo, boWriter, boTitle, boContent, boHit, boRegdate);
			
			list.add(vo);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}

		}
		return list;
	}
	
	//글내용조회
	public HBoardVO getContent(String boardNum) {
		
		HBoardVO vo = null;
		
		String sql = "SELECT * FROM HBOARD WHERE BOARDNUM = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int boardNum2 = rs.getInt("boardNum");
				//String memId = rs.getString("memId");
				//int hNo = rs.getInt("hNo");
				String boWriter = rs.getString("boWriter");
				String boTitle = rs.getString("boTitle");
				String boContent = rs.getString("boContent");
				int boHit = rs.getInt("boHit");
				Timestamp boRegdate = rs.getTimestamp("boRegdate");
			
				vo = new HBoardVO(boardNum2, null, 0, boWriter, boTitle, boContent, boHit, boRegdate);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}
		}
		return vo;
	}

	//글 수정하기
	public void update(String boardNum, String boTitle, String boContent) {
		
		String sql ="UPDATE HBOARD SET BOTITLE = ?, BOCONTENT = ? WHERE BOARDNUM = ? ";
	
		Connection conn = null;
		PreparedStatement pstmt =  null;
		
		
		try {

			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boTitle);
			pstmt.setString(2, boContent);
			pstmt.setString(3, boardNum);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
			}
		}
	}
	
	//hno에 맞는 리스트만 조회
	public List<HBoardVO> getHnoList(int hno) {
		
		List<HBoardVO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM HBOARD WHERE HNO = ? ORDER BY BOARDNUM DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, hno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			int boardNum = rs.getInt("boardNum");
			String memId = rs.getString("memId");
			int hNo = rs.getInt("hNo");
			String boWriter = rs.getString("boWriter");
			String boTitle = rs.getString("boTitle");
			String boContent = rs.getString("boContent");
			int boHit = rs.getInt("boHit");
			Timestamp boRegdate = rs.getTimestamp("boRegdate");
			
			HBoardVO vo = new HBoardVO(boardNum, memId, hNo, boWriter, boTitle, boContent, boHit, boRegdate);
			
			list.add(vo);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
			}

		}
		return list;
	}
}
