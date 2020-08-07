<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("utf-8");

	String memberID = request.getParameter("memberID");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	Connection con =null;
	PreparedStatement pstmt = null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userN = "scott";
		String passW = "1111";
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?)";
		
		con = DriverManager.getConnection(url, userN, passW);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, memberID);
		pstmt.setString(2, password);
		pstmt.setString(3, name);
		pstmt.setString(4, email);
		pstmt.executeUpdate();
		
	} finally {
		try {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
member 테이블에 새로운 레코드가 삽입되었습니다.
</body>
</html>