<%@page import="board.BoardDAO"%>
<%@page import="board.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	int num = Integer.parseInt(request.getParameter("num"));
	
	try {
		BoardDAO dbPro = BoardDAO.getInstance();
		BoardDTO article = dbPro.getArticle(num, boardid, false);
%>
<body>
<p class="w3-left" style="padding-left : 30px;"><%=board %></p>
<div class="w3-container">
	<center><b>글수정</b><br>
		<form method="post" name="writeForm" action="updatePro.jsp" enctype="multipart/form-data">
			<input type="hidden" name="num" value="<%=article.getNum()%>">
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<input type="hidden" name="ref" value="0">
			<input type="hidden" name="re_step" value="0">
			<input type="hidden" name="re_level" value="0">
			<input type="hidden" name="oldFile" value="<%=article.getFilename()%>">	<!-- 임시로 수정전 파일을 저장해놓음 -->
			<table class="w3-table=all" style="width : 70%;">
				<tr>
					<td align="right" colspan="2"><a href="list.jsp">글목록</a></td>
				</tr>
				<tr>
					<td width="70" align="center">이 름</td>
					<td width="330"><input type="text" size="10" maxlength="10" name="writer" value="<%=article.getWriter()%>"></td>
				</tr>
				<tr>
					<td width="70" align="center">제 목</td>
					<td width="330"><input type="text" size="40" maxlength="50" name="subject" value="<%=article.getSubject()%>"></td>
				</tr>
				<tr>
					<td width="70" align="center">Email</td>
					<td width="330"><input type="text" size="40" maxlength="30" name="email" value="<%=article.getEmail()%>"></td>
				</tr>
				<tr>
					<td width="70" align="center">내 용</td>
					<td width="330"><textarea name="content" rows="13" cols="40"><%=article.getContent()%></textarea></td>
				</tr>
				<tr>
					<td width="70" align="center">file</td>
					<td width="330"><input type="file" size="40" maxlength="30" name="uploadfile">[<%=article.getFilename()%>]</td>
				</tr>
				<tr>
					<td width="70" align="center">비밀번호</td>
					<td width="330"><input type="password" size="8" maxlength="12" name="passwd"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글쓰기">
						<input type="reset" value="다시작성">
						<input type="button" value="목록보기" onclick="window.location='list.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</center>
</div>
<%
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
</body>
</html>