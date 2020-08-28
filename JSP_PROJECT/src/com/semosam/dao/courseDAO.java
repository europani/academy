package com.semosam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import com.semosam.dto.courseDTO;
import com.semosam.dto.teacherDTO;

public class courseDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "teamproject";
	private final String PASS = "1111";

	public courseDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC ����̹� �ε� ����");
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
	
	public int updateCourse(courseDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int result = -1;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "UPDATE course SET category=?, difficulty=?, maxppl=?, address=?, content=?, notice=?, title=? WHERE coursenum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCategory());
			pstmt.setString(2, dto.getDifficulty());
			pstmt.setInt(3, dto.getMaxppl());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getNotice());
			pstmt.setString(7, dto.getTitle());
			pstmt.setInt(8, dto.getCoursenum());
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		
		return result;
	}
	
	public int deleteCourse(int courseNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "DELETE FROM course WHERE coursenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return result;
	}
	
	
	
	public ArrayList<courseDTO> getCourses(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT c.* FROM course c, member m WHERE m.email = ? AND c.memnum = m.memnum";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				courseDTO dto = new courseDTO();
				dto.setCoursenum(rs.getInt("coursenum"));
				dto.setCategory(rs.getString("category"));
				dto.setDifficulty(rs.getString("difficulty"));
				dto.setMaxppl(rs.getInt("maxppl"));
				dto.setAddress(rs.getString("address"));
				dto.setContent(rs.getString("content"));
				dto.setNotice(rs.getString("notice"));
				dto.setCourseimage(rs.getString("courseimage"));
				dto.setTitle(rs.getString("title"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public courseDTO getCourse(int courseNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		courseDTO dto = null;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT * FROM course WHERE coursenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dto = new courseDTO();
				dto.setCoursenum(courseNum);
				dto.setCategory(rs.getString("category"));
				dto.setDifficulty(rs.getString("difficulty"));
				dto.setMaxppl(rs.getInt("maxppl"));
				dto.setAddress(rs.getString("address"));
				dto.setContent(rs.getString("content"));
				dto.setNotice(rs.getString("notice"));
				dto.setTitle(rs.getString("title"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return dto;
	}
	
	public String getTitle(int courseNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		String result = "";
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT title FROM course WHERE coursenum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, courseNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return result;
	}
	
	public Vector<courseDTO> getCourseList(String category) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		
		Vector<courseDTO> vlist = null;
		try {

			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "select * from course c, member m, teacher t where c.memnum = m.memnum and m.memnum = t.memnum and category like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vlist = new Vector<courseDTO>();
				do {
					courseDTO course = new courseDTO();
					course.setCoursenum(rs.getInt("coursenum"));
					course.setMemnum(rs.getInt("memnum"));
					course.setCategory(rs.getString("category"));
					course.setDifficulty(rs.getString("difficulty"));
					course.setMaxppl(rs.getInt("maxppl"));
					course.setAddress(rs.getString("address"));
					course.setContent(rs.getString("content"));
					course.setNotice(rs.getString("notice"));
					course.setCourseimage(rs.getString("courseimage"));
					course.setTitle(rs.getString("title"));
					course.setTeacherName(rs.getString("name"));
					course.setTeacherImage(rs.getString("teacherimage"));
					course.setTeacherInfo(rs.getString("teacherinfo"));
					vlist.add(course);
				} while(rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return vlist;
	}

	public ArrayList<courseDTO> getSearchingResults(String keyword) throws Exception {
	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = "";
	      ArrayList<courseDTO> list = new ArrayList<courseDTO>();
	      try {

	         conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
	         sql = "select * " + 
	               "from course c, teacher t, member m " + 
	               "where c.memnum = t.memnum and m.memnum = t.memnum " + 
	               "and (c.title like ? or m.name like ? or c.content like ?) ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, "%" + keyword + "%");
	         pstmt.setString(2, "%" + keyword + "%");
	         pstmt.setString(3, "%" + keyword + "%");
	         rs = pstmt.executeQuery();
	         while(rs.next()) {
	            courseDTO course = new courseDTO();
	            course.setCoursenum(rs.getInt("coursenum"));
	            course.setMemnum(rs.getInt("memnum"));
	            course.setCategory(rs.getString("category"));
	            course.setDifficulty(rs.getString("difficulty"));
	            course.setMaxppl(rs.getInt("maxppl"));
	            course.setAddress(rs.getString("address"));
	            course.setContent(rs.getString("content"));
	            course.setNotice(rs.getString("notice"));
	            course.setCourseimage(rs.getString("courseimage"));
	            course.setTitle(rs.getString("title"));
	            course.setTeacherName(rs.getString("name"));
	            course.setTeacherImage(rs.getString("teacherimage"));
	            course.setTeacherInfo(rs.getString("teacherinfo"));
	            list.add(course);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         Util.close(conn, pstmt, rs);
	      }
	      return list;
	   }
	
	public ArrayList<courseDTO> getMyCourses(String email) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "select distinct (select name from member where memnum = c.memnum) AS tname, c.* from course c, member m, applicant a where a.coursenum = c.coursenum and a.memnum = m.memnum and m.email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					courseDTO dto = new courseDTO();
					dto.setCoursenum(rs.getInt("coursenum"));
					dto.setMemnum(rs.getInt("memnum"));
					dto.setCategory(rs.getString("category"));
					dto.setDifficulty(rs.getString("difficulty"));
					dto.setAddress(rs.getString("address"));
					dto.setCourseimage(rs.getString("courseimage"));
					dto.setTitle(rs.getString("title"));
					dto.setTeacherName(rs.getString("tname"));
					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return list;
	}

	public ArrayList<courseDTO> getMyWish(String email) throws Exception {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<courseDTO> list = new ArrayList<courseDTO>();

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT DISTINCT (SELECT name FROM member WHERE memnum = c.memnum) AS tname, c.* FROM course c, member m, wishlist w WHERE w.coursenum = c.coursenum AND w.memnum = m.memnum AND m.email=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					courseDTO dto = new courseDTO();
					dto.setCoursenum(rs.getInt("coursenum"));
					dto.setMemnum(rs.getInt("memnum"));
					dto.setCategory(rs.getString("category"));
					dto.setDifficulty(rs.getString("difficulty"));
					dto.setAddress(rs.getString("address"));
					dto.setCourseimage(rs.getString("courseimage"));
					dto.setTitle(rs.getString("title"));
					dto.setTeacherName(rs.getString("tname"));
					list.add(dto);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
