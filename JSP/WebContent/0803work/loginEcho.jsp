<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("passwd");
	
	if (pw.contains(id)) {
		out.println("�α��� �Ǿ����ϴ�.");
	} else {
		out.println("�α��� �Ұ��Դϴ�.");
	}
%>