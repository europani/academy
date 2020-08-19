<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String num = request.getParameter("num");
	String inputPasswd = request.getParameter("inputPasswd");

	try {
		BoardDAO dbPro = BoardDAO.getInstance();
		int result = dbPro.deleteArticle(num, inputPasswd, boardid);
		
		if (result == 1) {
%>
		<script type="text/javascript">
			alert('삭제되었습니다.');
		</script>
		<meta http-equiv="Refresh" content="0;url=list.jsp">
<%			
		} else {
%>
		<script type="text/javascript">
			alert('비밀번호가 맞지 않습니다.');
			history.go(-1);
		</script>
<%
		}
	} catch (Exception e) {}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>