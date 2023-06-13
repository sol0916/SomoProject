package com.somo.reply.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
	
	private String url = "jdbc:oracle:thin:@172.30.1.95:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";
	
	
	//댓글 등록하기
	public int insertReply(ReplyVO vo) {
		String sql = "insert into reply values (reply_seq.nextval,?,?,sysdate,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getrWriter());
			pstmt.setString(2, vo.getrContent());
			pstmt.setInt(3, vo.getBoardNum());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return -1;
	}
	
	//댓글 수정하기
	public int updateReply(int rno, String rcontent) {
		String sql = "update reply set rcontent = ? where rno = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, rcontent);
			pstmt.setInt(2, rno);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("updateReply메소드의 에러");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return -1;
	}
	
	//댓글 삭제하기
	public int deleteReply(int rno) {
		String sql = "delete from reply where rno = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, rno);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("deleteReply메소드의 에러");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}
		}
		
		return -1;
	}
	
	//댓글 조회하기
	public List<ReplyVO> getReply(int boardnum) {
		String sql = "select * from reply where boardnum =?";
		List<ReplyVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, uid, upw);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardnum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyVO vo = new ReplyVO(rs.getInt("rno"), rs.getString("rwriter"), rs.getString("rcontent")
						, rs.getTimestamp("rdate"), rs.getInt("boardnum"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("getReply메소드의 에러");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {

			}
		}
		
		return list;
	}
}
