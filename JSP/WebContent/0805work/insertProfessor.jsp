<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	request.setCharacterEncoding("utf-8");

	String profno = request.getParameter("profno");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String position = request.getParameter("position");
	String pay = request.getParameter("pay");
	String hiredate = request.getParameter("hiredate");
	String deptno = request.getParameter("deptno");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "1234";
		String sql = "INSERT INTO professor VALUES (?, ?, ?, ?, ?, ?, null, ?, null, null)";

		conn = DriverManager.getConnection(url, user, password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, profno);
		pstmt.setString(2, name);
		pstmt.setString(3, id);
		pstmt.setString(4, position);
		pstmt.setString(5, pay);
		pstmt.setString(6, hiredate);
		pstmt.setString(7, deptno);
		pstmt.executeUpdate();
	} finally {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null)  conn.close();
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
Professor 테이블에 INSERT 되었습니다.
교수번호 : <%=profno %><br>
교수명 : <%=name %><br>
직책 : <%=position %><br>
id : <%=id %><br>
입사일 : <%=hiredate %><br>
부서코드 : <%=deptno %><br>
pay : <%=pay %><br>
</body>
</html>