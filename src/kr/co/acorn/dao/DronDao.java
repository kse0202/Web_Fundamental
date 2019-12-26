package kr.co.acorn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.acorn.dto.DronDto;
import kr.co.acorn.util.ConnLocator;

public class DronDao {
	private static DronDao single;
	private DronDao() {}
	public static DronDao getInstance() {
		if(single == null) {
			single = new DronDao();
		}
		return single;
	}
	public ArrayList<DronDto> select(int start, int len){
		ArrayList<DronDto> list = new ArrayList<DronDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT no, dname, dprice, dland ");
			sql.append("FROM dron ");
			sql.append("ORDER BY no ");
			sql.append("LIMIT ?,? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index,start);
			pstmt.setInt(++index,len);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				index = 0;
				int no = rs.getInt(++index);
				String dname = rs.getString(++index);
				String dprice = rs.getString(++index);
				String dland = rs.getString(++index);
				list.add(new DronDto(no,dname,dprice,dland));
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
		return list;
	}
	
	public int getTotalRows() {
		int rows = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT COUNT(no) ");
			sql.append("FROM dron");
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			int index = 0;
			if(rs.next()) {
				rows = rs.getInt(++index);
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
		return rows;
	}
	
	public boolean insert(DronDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO dron(no, dname, dprice, dland) ");
			sql.append("VALUES(?,?,?,?)");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, dto.getNo());
			pstmt.setString(++index, dto.getDname());
			pstmt.setString(++index, dto.getDprice());
			pstmt.setString(++index, dto.getDland());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return isSuccess;
	}
	public DronDto select(int no){
		DronDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT no, dname, dprice, dland ");
			sql.append("FROM dron ");
			sql.append("WHERE no = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, no);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				index = 0;
				no = rs.getInt(++index);
				String dname = rs.getString(++index);
				String dprice = rs.getString(++index);
				String dland = rs.getString(++index);
				dto = new DronDto(no,dname,dprice,dland);
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
		return dto;
	}
	public boolean update(DronDto dto) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("UPDATE dron ");
			sql.append("SET dname=?, dprice=?, dland=? ");
			sql.append("WHERE no = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setString(++index, dto.getDname());
			pstmt.setString(++index, dto.getDprice());
			pstmt.setString(++index, dto.getDland());
			pstmt.setInt(++index, dto.getNo());
			
			pstmt.executeUpdate();
			
			isSuccess = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return isSuccess;
	}
	public boolean delete(int no) {
		boolean isSuccess = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = ConnLocator.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("DELETE FROM dron WHERE no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			int index = 0;
			pstmt.setInt(++index, no);
			
			pstmt.executeUpdate();
			
			isSuccess = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e2) {
				// TODO: handle exception
			}
		}
		
		return isSuccess;
	}
	
	
	
}










