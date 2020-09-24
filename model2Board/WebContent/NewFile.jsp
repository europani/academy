<%@page import="db.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="db.BoardMybatisDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
test
<%
	BoardMybatisDAO dao = new BoardMybatisDAO();
	List<BoardDTO> li = dao.boardAllList();
%>
<%=li %>
</body>
</html>