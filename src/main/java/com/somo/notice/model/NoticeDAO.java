package com.somo.notice.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class NoticeDAO {
	//싱글톤 형태의 클래스로 생성하는편이 좋습니다.
	//1. 나 자신의 객체를 스태틱으로 선언
	private static NoticeDAO instance = new NoticeDAO();
	//2. 직접 생성하지 못하도록 생성자 제한
	private NoticeDAO() {
		//생성자에서 드라이버클래스 호출
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}


	}
	//3. getter를 통해서 객체를 반환
	public static NoticeDAO getInstance() {
		return instance;
	}
	//데이터베이스 연결 주소
	//+오라클 커넥터
	private String url = "jdbc:oracle:thin:@172.30.1.95:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";

	//글 등록
	public void regist(String writer, String title, String content) {

		String sql="INSERT INTO NOTICE VALUES( BOARD_SEQ.NEXTVAL, ?,?,sysdate,0,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, writer);//writer

			pstmt.executeUpdate();



		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}

		}


	}

	//목록을 조회
	public List<NoticeVO> getList() {

		List<NoticeVO> list = new ArrayList<>();

		String sql = "SELECT * FROM NOTICE ORDER BY NTNO DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();

			/*
			 * 조회된 데이터를 순서대로 VO에 담고 리스트에 추가하는 프로그램코드 
			 */


			while(rs.next()) {

				//1행에 대한 처리
				int ntno = rs.getInt("ntno");
				String ntitle = rs.getString("nttitle");
				String ntcontent = rs.getString("ntcontent");
				Timestamp ntregdate = rs.getTimestamp("ntregdate");
				int nthit = rs.getInt("nthit");
				String memid = rs.getString("memid");

				NoticeVO vo = new NoticeVO(ntno,ntitle,ntcontent,ntregdate, nthit, memid);

				list.add(vo); //list추가


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

	//글내용을 조회
	public NoticeVO getContent(String bno) {

		NoticeVO vo = null;
		String sql = "select * from NOTICE where ntno = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);


			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				int ntno2 = rs.getInt("ntno");
				String ntitle = rs.getString("nttitle");
				String ntcontent = rs.getString("ntcontent");
				Timestamp ntregdate = rs.getTimestamp("ntregdate");
				int nthit = rs.getInt("nthit");
				String memid = rs.getString("memid");

				vo = new NoticeVO(ntno2,ntitle,ntcontent,ntregdate, nthit, memid);

			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				conn.close();
				pstmt.close();
				rs.close();


			} catch (Exception e2) {
				// TODO: handle exception
			}

		}

		return vo;
	}

	//글 수정기능
	public void update (String bno, String title, String content) {
		String sql ="UPDATE NOTICE SET NTTITLE = ?, NTCONTENT = ? WHERE NTNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;


		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, bno);

			pstmt.executeUpdate(); //끝

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				conn.close();
				pstmt.close();


			} catch (Exception e2) {

			}
		}
	}

	//조회수 증가
	public void hitup (String ntno) {
		String sql ="UPDATE NOTICE SET NTHIT = NTHIT + 1 WHERE NTNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;


		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ntno);
			pstmt.executeUpdate(); //끝

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				conn.close();
				pstmt.close();


			} catch (Exception e2) {

			}
		}
	}
	
	//삭제기능 구현
	public void delete (String ntno) {
		String sql ="DELETE FROM NOTICE WHERE NTNO = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url,uid,upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ntno);
			pstmt.executeUpdate(); //끝

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {

				conn.close();
				pstmt.close();


			} catch (Exception e2) {

			}
		}
	}
	
	

}
















