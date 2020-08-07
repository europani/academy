<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "1111";
	String sql = "SELECT * FROM emp";
	
	int counter = 0;
	
	try {
		con = DriverManager.getConnection(url, user, password);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="/jsp/bean/style.css" rel="stylesheet">
</head>
<body bgcolor="#ffc">
	<h2>JSP 스크립틀릿에서 데이터베이스 연동 예제</h2><br>
	<h3>회원정보</h3>
	<table bordercolor="#00f" border="1">
		<tr>
			<td><strong>empno</strong></td>
			<td><strong>ename</strong></td>
			<td><strong>job</strong></td>
			<td><strong>mgr</strong></td>
			<td><strong>hiredate</strong></td>
			<td><strong>sal</strong></td>
			<td><strong>comm</strong></td>
			<td><strong>deptno</strong></td>
		</tr>
		<%
			if (rs != null) {
				while (rs.next()) {
%>				<tr>
					<td><%=rs.getString(1) %></td>
					<td><%=rs.getString(2) %></td>
					<td><%=rs.getString(3) %></td>
					<td><%=rs.getString(4) %></td>
					<td><%=rs.getString(5) %></td>
					<td><%=rs.getInt(6) %></td>
					<td><%=rs.getString(7) %></td>
					<td><%=rs.getString(8) %></td>
				</tr>	
<%					counter++;			
				}
			}
		%>
	</table>
	<br>
	total records : <%=counter %>
	<% } catch (Exception e){
		System.out.println("exception");
		} finally {
			if (rs != null) try {rs.close(); } catch (Exception e) {}
			if (stmt != null) try {stmt.close(); } catch (Exception e) {}
			if (con != null) try {con.close(); } catch (Exception e) {}
		}
	%>

</body>
</html>