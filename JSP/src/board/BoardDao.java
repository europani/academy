package board;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import member.Util;

public class BoardDao {
	private final String SAVEFOLDER = "C:\\Temp\\fileUpload";
	private final String ENCTYPE = "EUC-KR";
	private final int MAXSIZE = 5 * 1024 * 1024;

	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "scott";
	private final String PASS = "1111";

	public BoardDao() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 로딩 실패");
		}
	}

	public void insertBoard(HttpServletRequest request) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		MultipartRequest multi = null;
		int filesize = 0;
		String filename = null;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT nvl(max(num), 0) FROM tblboard"; // 글번호
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int ref = 0;
			int num = 0;

			if (rs.next()) {
				num = rs.getInt(1) + 1;
				ref = num; // 새글은 ref=num
			}

			File file = new File(SAVEFOLDER);
			if (!file.exists()) {
				file.mkdir();
			}

			multi = new MultipartRequest(request, SAVEFOLDER, MAXSIZE, ENCTYPE, new DefaultFileRenamePolicy());
			if (multi.getFilesystemName("filename") != null) {
				filename = multi.getFilesystemName("filename");
				filesize = (int) multi.getFile("filename").length();
			}
			String content = multi.getParameter("content");
			/*
			 * if (multi.getParameter("contentType").equalsIgnoreCase("TEXT")) { content =
			 * UtilMgr.replace(content, "<", "&lt;");; }
			 */
			sql = "INSERT INTO tblboard(num, name, content, subject, ref, pos,"
					+ "depth, regdate, pass, count, ip, filename, filesize)";
			sql += "VALUES (?, ?, ?, ?, ?, 0, 0, sysdate, ?, 0, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, multi.getParameter("name"));
			pstmt.setString(3, content);
			pstmt.setString(4, multi.getParameter("subject"));
			pstmt.setInt(5, ref);
			pstmt.setString(6, multi.getParameter("pass"));
			pstmt.setString(7, multi.getParameter("ip"));
			pstmt.setString(8, filename);
			pstmt.setInt(9, filesize);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
	}
	
	public int getTotalCount(String keyField, String keyWord) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int totalCount = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			if (keyWord.equals("null")|| keyWord.equals("")) {
				sql = "SELECT count(num) FROM tblboard";
				pstmt = conn.prepareStatement(sql);
			} else {
				sql = "SELECT count(num) FROM tblboard WHERE"
					+ keyField + "like ? ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyWord + "%");
			}
			rs = pstmt.executeQuery();
			
			if (rs !=null) {
				while (rs.next()) {
					totalCount = rs.getInt(1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		
		return totalCount;
	}
	
	public ArrayList<BoardDto> getBoardList(String keyField, String keyWord, int start, int end) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			if (keyWord.equals("null")|| keyWord.equals("")) {
				sql = "SELECT * FROM (SELECT ROWNUM rnum, A.* "
						+ "FROM (SELECT * FROM tblboard ORDER BY ref DESC, pos) A) WHERE rnum BETWEEN ? AND ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, start);
				pstmt.setInt(2, (start+end));
			} else {
				sql = "SELECT * FROM (SELECT ROWNUM rnum, A.* "
						+ "FROM (SELECT * FROM tblboard WHERE " + keyField + " LIKE ? "
								+ "ORDER BY ref DESC, pos) A) WHERE rnum BETWEEN ? AND ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + keyWord + "%");
				pstmt.setInt(2, start);
				pstmt.setInt(3, end);
			}
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					BoardDto dto = new BoardDto();
					dto.setNum(rs.getInt("num"));
					dto.setName(rs.getString("name"));
					dto.setSubject(rs.getString("subject"));
					dto.setPos(rs.getInt("pos"));
					dto.setRef(rs.getInt("ref"));
					dto.setDepth(rs.getInt("depth"));
					dto.setRegdate(rs.getString("regdate"));
					dto.setCount(rs.getInt("count"));
					list.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public void post1000() { 	// 페이징 및 블럭 테스트를 위한 게시물 저장 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int index = 3;

		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			for (int i = 0; i < 100; i++) {
				String sql = "INSERT INTO tblboard(num, name, content, subject, ref, pos, depth, regdate, pass, count, ip, filename, filesize)";
				sql += "VALUES (" + (++index) + ", 'aaa', 'bbb', 'ccc', " + index
						+ ", 0, 0, sysdate, '1111', 0, '127.0.0.1', null, 0)";
				pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
	}
	
	public static void main(String[] args) {
		new BoardDao().post1000();
		System.out.println("SUCCESS!!");
	}

}
