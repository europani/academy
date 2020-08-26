package com.semosam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.semosam.dto.applicantDTO;
import com.semosam.dto.memberDTO;

public class applicantDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "teamproject";
	private final String PASS = "1111";

	public applicantDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC ����̹� �ε� ����");
		}
	}
	
	public ArrayList<memberDTO> getApplicant(int coursenum, int serial) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		applicantDTO dtoA = new applicantDTO();
		ArrayList<memberDTO> list = new ArrayList<memberDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT m.* FROM applicant a, member m WHERE a.memnum = m.memnum AND coursenum=? AND serial=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, coursenum);
			pstmt.setInt(2, serial);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				memberDTO dtoM = new memberDTO();
				dtoM.setEmail(rs.getString("email"));
				dtoM.setName(rs.getString("name"));
				dtoM.setGender(rs.getString("gender"));
				dtoM.setTel(rs.getString("tel"));
				list.add(dtoM);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return list;
	}
}
