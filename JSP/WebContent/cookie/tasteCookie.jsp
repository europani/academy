<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Taste Cookie</title>
</head>
<body>
<h1>Example Cookie</h1>
<%
	Cookie[] cookies = request.getCookies();		// 쿠키를 클라이언트 -> 서버
	if (cookies != null) {
		for (int i=0; i<cookies.length; i++) {
			/* if (cookies[i].getName().equals("myCookie")) { */
%>
				Cookie name : <%=cookies[i].getName() %><br>
				Cookie Value : <%=cookies[i].getValue() %><br>
<%
			/* } */
		}
	}


%>
</body>
</html>