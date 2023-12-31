package com.somo.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.somo.hboard.model.HBoardVO;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();

	//생성자
	private MemberDAO() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			System.out.println("클래스 호출 오류");
		}

	}

	public static MemberDAO getInstance() {
		return instance;
	}

	//db연결주소
	private String url = "jdbc:oracle:thin:@172.30.1.95:1521:xe";
	private String uid = "SOMO";
	private String upw = "SOMO";


	//id 중복검사
	public int idCheck(String memId) {
		int result = 1;

		String sql = "select * from member where memId =?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();


			if(rs.next()) { //중복
				result = 1;
			} else {
				result = 0;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return result;
	}

	//nickName 중복검사
	public int nickCheck(String memNick) {

		int result = 1;

		String sql = "select * from member where memNick = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memNick);

			rs = pstmt.executeQuery();


			if(rs.next()) { //중복
				result = 1;
			} else { //중복 x
				result = 0;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return result;
	}

	//비밀번호 체크
	public int pwCheck(String id, String memPw) {

		int result = 0;

		String sql = "select * from member where memPw = ? and memid= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memPw);
			pstmt.setString(2, id);

			rs = pstmt.executeQuery();


			if(rs.next()) {
				result = 1;
			} else { 
				result = 0;
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;

	}

	//회원가입
	public void join(MemberVO vo) {

		String sql = "insert into member(memId, memPw, memName, memPhone, memAddr, memGender, memBirth, memType, memNick, memEmail)"
				+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemId());
			pstmt.setString(2, vo.getMemPw());
			pstmt.setString(3, vo.getMemName());
			pstmt.setString(4, vo.getMemPhone());
			pstmt.setString(5, vo.getMemAddr());
			pstmt.setString(6, vo.getMemGender());
			pstmt.setString(7, vo.getMemBirth());
			pstmt.setString(8, vo.getMemType());
			pstmt.setString(9, vo.getMemNick());
			pstmt.setString(10, vo.getMemEmail());

			pstmt.executeUpdate(); //성공시 1, 실패시 0

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	//로그인
	public MemberVO login(String memId, String memPw) {

		MemberVO vo = null;

		String sql = "select * from member where memid = ? and mempw = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			pstmt.setString(2, memPw);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				String memId2 = rs.getString("memId");
				String memName = rs.getString("memName");
				String memPhone = rs.getString("memPhone");
				String memAddr = rs.getString("memAddr");
				String memGender = rs.getString("memGender");
				String memBirth = rs.getString("memBirth");
				String memType = rs.getString("memType");
				String memNick = rs.getString("memNick");
				String memEmail = rs.getString("memEmail");

				vo = new MemberVO(memId2, null, memName, memPhone, memAddr, memGender, memBirth, memType, memNick, memEmail);

			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return vo;
	}

	//정보 가져오기 - 개인
	public MemberVO getInfo(String memId) {

		MemberVO vo = null;

		String sql = "select * from member where memId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				String memId2 = rs.getString("memId");
				String memName = rs.getString("memName");
				String memPhone = rs.getString("memPhone");
				String memAddr = rs.getString("memAddr");
				String memGender = rs.getString("memGender");
				String memBirth = rs.getString("memBirth");
				String memType = rs.getString("memType");
				String memNick = rs.getString("memNick");
				String memEmail = rs.getString("memEmail");

				vo = new MemberVO(memId2, null, memName, memPhone, memAddr, memGender, memBirth, memType, memNick, memEmail);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return vo;
	}

	//전체 정보 가져오기 - 리스트 
	public List<MemberVO> getMemList() {

		List<MemberVO> list = new ArrayList<>();
		MemberVO vo = null;

		String sql = "select * from member";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				String memId2 = rs.getString("memId");
				String memName = rs.getString("memName");
				String memPhone = rs.getString("memPhone");
				String memAddr = rs.getString("memAddr");
				String memGender = rs.getString("memGender");
				String memBirth = rs.getString("memBirth");
				String memType = rs.getString("memType");
				String memNick = rs.getString("memNick");
				String memEmail = rs.getString("memEmail");

				vo = new MemberVO(memId2, null, memName, memPhone, memAddr, memGender, memBirth, memType, memNick, memEmail);

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
				e2.printStackTrace();
			}
		}

		return list;
	}

	//정보 수정하기
	public int updateInfo(MemberVO vo) {

		int result = 0;

		String sql = "update member set memNick=?, memEmail=?, memPhone=?, memAddr=?, memBirth=?, memGender=?"
				+"where memId=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemNick());
			pstmt.setString(2, vo.getMemEmail());
			pstmt.setString(3, vo.getMemPhone());
			pstmt.setString(4, vo.getMemAddr());
			pstmt.setString(5, vo.getMemBirth());
			pstmt.setString(6, vo.getMemGender());
			pstmt.setString(7, vo.getMemId());

			result = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return result;
	}

	//정보 삭제 (회원 탈퇴) 
	public int deleteInfo(String memId) {

		int result = 0;

		String sql = "delete from member where memId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			result = pstmt.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		return result;
	}

	//작성 글 보기
	public List<HBoardVO> findMyBoard(String memId) {

		List<HBoardVO> list = new ArrayList<>();

		String sql = "select * from hboard where memId = ? order by boardnum desc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {

			conn = DriverManager.getConnection(url, uid, upw);

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);

			rs = pstmt.executeQuery();

			while(rs.next()) {

				int boardNum = rs.getInt("boardNum");
				String memId2 = rs.getString("memId");
				int hNo = rs.getInt("hNo");
				String boWriter = rs.getString("boWriter");
				String boTitle = rs.getString("boTitle");
				String boContent = rs.getString("boContent");
				int boHit = rs.getInt("boHit");
				Timestamp boRegdate = rs.getTimestamp("boRegdate");

				HBoardVO vo = new HBoardVO(boardNum, memId2, hNo, boWriter, boTitle, boContent, boHit, boRegdate);

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
				e2.printStackTrace();
			}
		}


		return list;

	}
}
