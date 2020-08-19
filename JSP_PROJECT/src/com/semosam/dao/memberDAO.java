package com.semosam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.semosam.dto.memberDTO;

public class memberDAO {

	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "teamproject";
	private final String PASS = "1111";

	public memberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 드라이버 로딩 실패");
		}
	}

	public boolean login(String email, String pwd) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "select email,pwd from member where email=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pwd);

			flag = pstmt.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return flag;
	}

	
	public boolean checkId(String id) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "select id from tblMember where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			flag = pstmt.executeQuery().next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return flag;
	}

	public boolean insertMember(memberDTO bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		boolean flag = false;
		int number = 0;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			pstmt = conn.prepareStatement("select memnum.nextval from dual");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			sql = "insert into member(memnum,email,pwd,name,gender,tel,interest) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, bean.getEmail());
			pstmt.setString(3, bean.getPwd());
			pstmt.setString(4, bean.getName());
			pstmt.setString(5, bean.getGender());
			pstmt.setString(6, bean.getTel());
			pstmt.setString(7, bean.getInterest());
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return flag;

	}
}