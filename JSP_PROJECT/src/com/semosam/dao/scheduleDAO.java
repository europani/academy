package com.semosam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.semosam.dto.scheduleDTO;

public class scheduleDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "teamproject";
	private final String PASS = "1111";

	public scheduleDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC ����̹� �ε� ����");
		}
	}
	
	public int addSchedule(scheduleDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int result = -1;
		int serial = -1;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT nvl(max(serial), 0) FROM schedule WHERE coursenum= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCoursenum());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					serial = 1;
				} else {
					serial = rs.getInt(1) + 1;
				}
			}
			sql = "INSERT INTO schedule VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCoursenum());
			pstmt.setInt(2, serial);
			pstmt.setString(3, dto.getDay());
			pstmt.setInt(4, dto.getRuntime());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		
		return result;
	}
	
	public ArrayList<scheduleDTO> getSchedules(int courseNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<scheduleDTO> list = new ArrayList<scheduleDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT * FROM schedule WHERE coursenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				scheduleDTO dto = new scheduleDTO();
				dto.setCoursenum(rs.getInt("coursenum"));
				dto.setSerial(rs.getInt("serial"));
				dto.setDay(rs.getString("day"));
				dto.setRuntime(rs.getInt("runtime"));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public int deleteSchedule(int courseNum, int serial) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = -1;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "DELETE FROM schedule WHERE coursenum=? AND serial=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			pstmt.setInt(2, serial);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return result;
	}
	
}
