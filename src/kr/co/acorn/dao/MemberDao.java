package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.acorn.dto.MemberDto;
import kr.co.acorn.util.ConnLocator;

public class MemberDao {
	private static MemberDao single;

	private MemberDao() {
	}

	public static MemberDao getInstance() {
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	}
	public boolean isEmail(String email) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT m_email ");
			sql.append("from member ");
			sql.append("where m_email = ? ");
		
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, email);
		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				index = 0;
				isSuccess = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}
	public boolean insert(MemberDto dto) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO member(m_email, m_name, m_pwd, m_phone, m_regdate) ");
			sql.append("VALUES(?,?,PASSWORD(?),?,NOW()) ");
		
		
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getName());
			pstmt.setString(++index, dto.getEmail());
			pstmt.setString(++index, dto.getPassword());
			pstmt.setString(++index, dto.getPhone());
			//pstmt.setString(++index, dto.getRegdate());
		
			rs = pstmt.executeQuery();
			
				isSuccess = true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return isSuccess;
	}
	public MemberDto getMember(MemberDto dto) {
		MemberDto memberDto = null; //일치하지 않은경우 if문 돌릴때 처리하기 위해서 따로 선언한다
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT m_email, m_name, m_phone, DATE_FORMAT(m_regdate,'%Y/%m/%d') ");
			sql.append("FROM member ");
			sql.append("WHERE m_email = ? AND m_pwd = PASSWORD(?) ");
		
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getEmail());
			pstmt.setString(++index, dto.getPassword());
		
			rs = pstmt.executeQuery();
			if(rs.next()) {
				index = 0;
				String email = rs.getString(++index);
				String name = rs.getString(++index);
				String phone = rs.getString(++index);
				String regdate = rs.getString(++index);
				memberDto = new MemberDto(email,name,null,phone,regdate);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		return memberDto;
	}
	
	
	
	
}
