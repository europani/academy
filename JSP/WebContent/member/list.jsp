<%@page import="java.util.ArrayList"%>
<%@page import="member.MemberDTO"%>
<%@page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
%>
<%
	MemberDAO mgr = new MemberDAO();
	ArrayList<MemberDTO> memberList = mgr.selectMember();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFCC">
	<h2 align="center">Member List</h2>
<table align="center" >
	<tr bgcolor="#dfe6e9" align="center" >
		<td><Strong>ȸ��id</Strong></td>
		<td><Strong>�� ��</Strong></td>
		<td><Strong>�� ��</Strong></td>
		<td><Strong>�������</Strong></td>
		<td><Strong>email</Strong></td>
		<td><Strong>�����ȣ</Strong></td>
		<td><Strong>�� ��</Strong></td>
		<td><Strong>�� ��</Strong></td>
		<td><Strong>�� ��</Strong></td>
	</tr>
	<tr>
		<%
			for (int i=0; i < memberList.size(); i++) {
				MemberDTO bean = memberList.get(i);
		%>
		<td><%=bean.getId() %></td>
		<td><%=bean.getName() %></td>
		<td><%=bean.getGender() %></td>
		<td><%=bean.getBirthday() %></td>
		<td><%=bean.getEmail() %></td>
		<td><%=bean.getZipcode() %></td>
		<td><%=bean.getAddress() %></td>
		<td><%=bean.getNewhobby() %></td>
		<td><%=bean.getJob() %></td>
	</tr>
		<%	
			}
		
		%>
	
</table>
</body>
</html>