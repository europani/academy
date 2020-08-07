<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	request.setCharacterEncoding("euc-kr");
	String name = "Korea Football";
%>
<body>
<h1>Include Tag Example1</h1>
<jsp:include page="includeTagTop1.jsp" />
include ActionTag의 BODY 입니다.
</body>