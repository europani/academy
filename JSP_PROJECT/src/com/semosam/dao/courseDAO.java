package com.semosam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.semosam.dto.courseDTO;
import com.semosam.dto.teacherDTO;

public class courseDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "JSP_Project";
	private final String PASS = "1111";

	public courseDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 드라이버 로딩 실패");
		}
	}

	public boolean insertCourse(courseDTO bean, String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";

		boolean flag = false;
		int courseNum=0;
		int memNum = 0;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			
			
			pstmt = conn.prepareStatement("select coursenum.nextval from dual");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				courseNum = rs.getInt(1) + 1;
			} else {
				courseNum = 1;
			}
			
			pstmt = conn.prepareStatement("select memnum from member where email=?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memNum = rs.getInt(1);
			}

			sql = "insert into course(coursenum,memnum,title,category,difficulty,maxppl,address,content,notice,courseimage)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			pstmt.setInt(2, memNum);
			pstmt.setString(3, bean.getTitle());
			pstmt.setString(4, bean.getCategory());
			pstmt.setString(5, bean.getDifficulty());
			pstmt.setInt(6, bean.getMaxppl());
			pstmt.setString(7, bean.getAddress());
			pstmt.setString(8, bean.getContent());
			pstmt.setString(9, bean.getNotice());
			pstmt.setString(10, bean.getCourseimage());
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
