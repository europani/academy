package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DrivetText {
	public static void main(String[] args) {
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "1111");
			System.out.println("Success");
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
