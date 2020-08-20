package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;


public class MemberDAO {
	private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "scott";
	private final String PASS = "1111";
	
	public MemberDAO() {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (Exception e) {
			System.out.println("Error : JDBC 로딩 실패");
		}
	}
	
	
	public boolean insertMember(MemberDTO bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "INSERT INTO tblmember VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getPwd());
			pstmt.setString(3, bean.getName());
			pstmt.setString(4, bean.getGender());
			pstmt.setString(5, bean.getBirthday());
			pstmt.setString(6, bean.getEmail());
			pstmt.setString(7, bean.getZipcode());
			pstmt.setString(8, bean.getAddress());
			
		/*	String[] hobby = bean.getHobby();
			char hb[] = {'0', '0', '0', '0', '0'};		
			String lists[] = {"internet", "travel", "game", "movie", "exercise"};
			
			for (int i = 0; i < hobby.length; i++) {
				for (int j = 0; j < lists.length; j++) {
					if (hobby[i].equals(lists[j])) {
						hb[j] = '1';	// 체크돼있으면 1부여
					}
				}
			}
			pstmt.setString(9, new String(hb));
		*/	
			pstmt.setString(9, bean.getNewhobby());
			pstmt.setString(10, bean.getJob());
			if (pstmt.executeUpdate() == 1) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return flag;
	}

	public boolean checkID(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT id FROM tblmember WHERE id = ?";
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
	
/*	public Vector<ZipcodeBean> zipcodeRead(String area3) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Vector<ZipcodeBean> vlist = new Vector<ZipcodeBean>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT * FROM tblzipcode WHERE area3 like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + area3 + "%");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ZipcodeBean bean = new ZipcodeBean();
				bean.setZipcode(rs.getString(1));
				bean.setArea1(rs.getString(2));
				bean.setArea2(rs.getString(3));
				bean.setArea3(rs.getString(4));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return vlist;
	}
*/	
	public boolean loginMember(String id, String pwd) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT id FROM tblmember WHERE id = ? AND pwd = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			flag = rs.next();
					
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return flag;
	}
	
	
	
	
	public MemberDTO getMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		MemberDTO bean = new MemberDTO();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT * FROM tblmember WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					bean.setId(rs.getString("id"));
					bean.setName(rs.getString("pwd"));
					bean.setName(rs.getString("name"));
					bean.setGender(rs.getString("gender"));
					bean.setBirthday(rs.getString("birthday"));
					bean.setEmail(rs.getString("email"));
					bean.setZipcode(rs.getString("zipcode"));
					bean.setAddress(rs.getString("address"));
					
				/*	String[] hobby = new String[5];
					
					String h = rs.getString("hobby");	//01010
					
					for (int i = 0; i < hobby.length; i++) {
						hobby[i] = h.substring(i, i+1);		// 배열화
					}
					bean.setHobby(hobby);
				*/
					bean.setNewhobby(rs.getString("hobby"));
					bean.setJob(rs.getString("job"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		return bean;
	}
	
	public int updateMember(MemberDTO bean) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "UPDATE tblmember SET pwd=?, name=?, gender=?, birthday=?, email=?, zipcode=?, address=?, hobby=?, job=? WHERE id = '" + bean.getId() + "'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bean.getPwd());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getGender());
			pstmt.setString(4, bean.getBirthday());
			pstmt.setString(5, bean.getEmail());
			pstmt.setString(6, bean.getZipcode());
			pstmt.setString(7, bean.getAddress());
			
		/*	String[] hobby = bean.getHobby();
			char hb[] = {'0', '0', '0', '0', '0'};		
			String lists[] = {"internet", "travel", "game", "movie", "exercise"};
			
			for (int i = 0; i < hobby.length; i++) {
				for (int j = 0; j < lists.length; j++) {
					if (hobby[i].equals(lists[j])) {
						hb[j] = '1';	// 체크돼있으면 1부여
					}
				}
			}
			pstmt.setString(8, new String(hb));
		*/	
			pstmt.setString(8, bean.getNewhobby());
			pstmt.setString(9, bean.getJob());
			rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		return rs;
	}
	
	
	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "DELETE FROM tblmember where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt);
		}
		
		return rs;
	}
	
	public ArrayList<MemberDTO> selectMember() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDTO> memberList = new ArrayList<MemberDTO>();
		
		try {
			conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
			String sql = "SELECT * FROM tblmember";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs != null) {
				while (rs.next()) {
					MemberDTO bean = new MemberDTO();
					bean.setId(rs.getString("id"));
					bean.setName(rs.getString("name"));
					bean.setGender(rs.getString("gender"));
					bean.setBirthday(rs.getString("birthday"));
					bean.setEmail(rs.getString("email"));
					bean.setZipcode(rs.getString("zipcode"));
					bean.setAddress(rs.getString("address"));
					bean.setNewhobby(rs.getString("hobby"));
					bean.setJob(rs.getString("job"));
					memberList.add(bean);
				}
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Util.close(conn, pstmt, rs);
		}
		
		return memberList;
	}
}
