package poll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

public class PollDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "scott";
	private final String PASS = "1111";

	public PollDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 로딩 실패");
		}
	}

	public int getMaxNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int maxNum = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT nvl(max(num), 0) FROM tblPollList";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				maxNum = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return maxNum;
	}
		
	public Vector<PollListDTO> getAllList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		Vector<PollListDTO> vlist = new Vector<PollListDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT * FROM tblPollList ORDER BY num DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PollListDTO pDto = new PollListDTO();
				pDto.setNum(rs.getInt("num"));
				pDto.setQuestion(rs.getString("question"));
				pDto.setSdate(rs.getString("sdate"));
				pDto.setEdate(rs.getString("edate"));
				vlist.add(pDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vlist;
	}
	
	public boolean insertPoll(PollListDTO plDto, PollItemDTO piDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		boolean flag = false;
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "INSERT INTO tblPollList(num, question, sdate, edate, wdate, type) VALUES (?, ?, ?, ?, sysdate, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getMaxNum()+1);
			pstmt.setString(2, plDto.getQuestion());
			pstmt.setString(3, plDto.getSdate());
			pstmt.setString(4, plDto.getEdate());
			pstmt.setInt(5, plDto.getType());
			int result = pstmt.executeUpdate();
			
			if (result == 1) {
				sql = "INSERT INTO tblPollItem VALUES(?, ?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				String[] item = piDto.getItem();
				int itemnum = getMaxNum();
				int j = 0;
				for (int i = 0; i < item.length; i++) {
					if (item[i] == null || item[i].equals("")) {
						break;
					}
					pstmt.setInt(1, itemnum);
					pstmt.setInt(2, i);
					pstmt.setString(3, item[i]);
					pstmt.setInt(4, 0);
					j = pstmt.executeUpdate();
				}
				if (j > 0) {
					flag = true;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return flag;
	}
	
	public PollListDTO getList(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		PollListDTO dto = new PollListDTO();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			if (num == 0) {
				sql = "SELECT * FROM tblPollList ORDER BY num DESC";
			} else {
				sql = "SELECT * FROM tblPollList WHERE num=" + num;
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				dto.setQuestion(rs.getString("question"));
				dto.setType(rs.getInt("type"));
				dto.setActive(rs.getInt("active"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public ArrayList<String> getItem(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			if (num == 0) {
				num = getMaxNum();
			}
			sql = "SELECT item from tblPollItem WHERE listnum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	public boolean updatePoll(int num, String[] itemnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "UPDATE tblPollItem SET count = count+1 WHERE listnum = ? AND itemnum = ?";
			pstmt = conn.prepareStatement(sql);
			if (num == 0) {
				num = getMaxNum();
			}
			for (int i = 0; i < itemnum.length; i++) {
				if (itemnum[i] == null || itemnum[i].equals("")) break;
				pstmt.setInt(1, num);
				pstmt.setInt(2, Integer.parseInt(itemnum[i]));
				int j = pstmt.executeUpdate();
				if (j > 0) {
					flag = true;
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
	public int sumCount(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT sum(count) FROM tblPollItem WHERE listnum = ?";
			pstmt = conn.prepareStatement(sql);
			if (num == 0) {
				pstmt.setInt(1, getMaxNum());
			} else {
				pstmt.setInt(1, num);
			}
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return count;
	}
	
	public ArrayList<PollItemDTO> getView(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "";
		ArrayList<PollItemDTO> list = new ArrayList<PollItemDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			sql = "SELECT item, count FROM tblPollItem WHERE listnum = ?";
			pstmt = conn.prepareStatement(sql);
			if (num == 0) {
				pstmt.setInt(1, getMaxNum());
			} else {
				pstmt.setInt(1, num);
			}
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				PollItemDTO piDto = new PollItemDTO();
				String item[] = new String[1];
				item[0] = rs.getString(1);
				piDto.setItem(item);
				piDto.setCount(rs.getInt(2));
				list.add(piDto);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
}
