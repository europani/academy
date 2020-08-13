package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {};
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe"; 
			final String USER = "scott";
			final String PASS = "1111";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	}

	public void insertArticle(BoardDTO article, String boardid) {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 1
		int num = article.getNum();
		int ref = article.getRef();
		int re_step = article.getRe_step();
		int re_level = article.getRe_level();
		
		// 1 답글쓰기
		int number = 0;
		String sql = "";
		
		try {
			sql = "SELECT boardser.nextval from dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}
			
			if (num != 0) {		// 답글
				sql = "UPDATE board SET re_step=re_step + 1 WHERE ref = ? AND re_step > ? AND boardid = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, re_step);
				pstmt.setString(3, boardid);
				pstmt.executeUpdate();
				re_step = re_step + 1;
				re_level = re_level + 1;
			} else {	// 새글
				ref = number;
				re_step = 0;
				re_level = 0;
			}
			
			sql = "INSERT INTO board(num, writer, email, subject, passwd, reg_date, ref, re_step, re_level, content, ip, boardid, filename, filesize) "
					+ "VALUES(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, number);
			pstmt.setString(2, article.getWriter());
			pstmt.setString(3, article.getEmail());
			pstmt.setString(4, article.getSubject());
			pstmt.setString(5, article.getPasswd());
			pstmt.setInt(6, ref);
			pstmt.setInt(7, re_step);
			pstmt.setInt(8, re_level);
			pstmt.setString(9, article.getContent());
			pstmt.setString(10, article.getIp());
			pstmt.setString(11, boardid);
			pstmt.setString(12, article.getFilename());
			pstmt.setInt(13, article.getFilesize());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
	}
}
