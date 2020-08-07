<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("UTF-8");

	String memberID = request.getParameter("memberID");
	String name = request.getParameter("name");

	int updateCount = 0;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection conn = null;
	Statement stmt = null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userN = "scott";
		String passW = "1111";
		String sql = "UPDATE member SET name = '" + name + "'" + "WHERE memberID = '" + memberID + "'";
		
		conn = DriverManager.getConnection(url, userN, passW);
		stmt = conn.createStatement();
		updateCount = stmt.executeUpdate(sql);
		
		
	} finally {
		if (stmt != null) {
			try { stmt.close();} catch (Exception e) {}
		} if (conn != null) {
			try {conn.close();} catch (Exception e) {}
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
<%
	if (updateCount >0) {
%>	<%=memberID %>의 이름을 <%=name %>으로 변경		
<%	} else {
%>	<%=memberID %> 아이디가 존재하지 않음	
<%
}
%>
</body>
</html>