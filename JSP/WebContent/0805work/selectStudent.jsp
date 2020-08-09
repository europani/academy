<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");

	String dname = request.getParameter("dname");

	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	
	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "1234";
		String sql = "SELECT name FROM student WHERE deptno1 = (SELECT deptno FROM department WHERE dname = ?)";      
		
		conn = DriverManager.getConnection(url, user, password);
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1, dname);
		rs = pstmt.executeQuery();
%>
<body bgcolor="#ffc">
	<table bordercolor="#00f" border="1">
		<tr>
			<td><strong>¿Ã∏ß</strong></td>
		</tr>
		<%
			if (rs != null) {
				while (rs.next()) {
%>				<tr><td><%=rs.getString(1) %></td></tr>	
<%								
				}
			}
		%>
	</table>
	<br>
	<% } catch (Exception e){
		e.printStackTrace();
		System.out.println("exception");
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	%>

</body>
