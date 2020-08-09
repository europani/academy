<%@page import="JDBC.RegisterDAO"%>
<%@page import="beans.RegisterDTO"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSP에서 DB 연동</title>
<link href="/jsp/bean/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h2>Bean을 사용한 DB 연동 예제</h2>
<h3>회원 정보</h3>
<table>
	<tr>
		<td><Strong>EMPNO</Strong></td>
		<td><Strong>ENAME</Strong></td>
		<td><Strong>JOB</Strong></td>
		<td><Strong>MGR</Strong></td>
		<td><Strong>HIREDATE</Strong></td>
		<td><Strong>SAL</Strong></td>
		<td><Strong>COMM</Strong></td>
		<td><Strong>DEPTNO</Strong></td>
	</tr>
	<%
		RegisterDAO regMgr = new RegisterDAO();
		Vector<RegisterDTO> vlist = regMgr.getRegisterList();
		int counter = vlist.size();
		for (int i=0; i < vlist.size(); i++) {
			RegisterDTO regBean = vlist.get(i);
	%>
	<tr>
		<td><%=regBean.getEmpno() %></td>
		<td><%=regBean.getEname() %></td>
		<td><%=regBean.getJob() %></td>
		<td><%=regBean.getMgr() %></td>
		<td><%=regBean.getHiredate() %></td>
		<td><%=regBean.getSal() %></td>
		<td><%=regBean.getComm() %></td>
		<td><%=regBean.getDeptno() %></td>
	</tr>
<%			
		}
%>
<table>
총 갯수 : <%= counter %>
</body>
</html>