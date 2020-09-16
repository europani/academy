<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<br><br>
	<b>글내용 보기</b>
	<div class="container">
		<table class="w3-table-all" style="width: 80%;">
			<tr height="30">
				<td width="125" align="center">글번호</td>
				<td width="125" align="center">${article.num}</td>
				<td width="125">조회수</td>
				<td width="125" align="center">${article.readcount}</td>
			</tr>
			<tr height="30">
				<td width="125">작성자</td>
				<td width="125" align="center">${article.writer}</td>
				<td width="125" align="center">작성일</td>
				<td align="center" width="125" align="center">${article.reg_date}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125">글제목</td>
				<td align="center" width="375" colspan="3">${article.subject}</td>
			</tr>
			<tr height="30">
				<td align="center" width="125">글내용</td>
				<td align="left" width="375" colspan="3"><pre>${article.content}</pre>
					<img src="<%=request.getContextPath()%>/uploadFile/${article.filename}"></td>
			</tr>
			<tr height="30">
				<td colspan="4" class="w3-center"><input type="button"
					value="글수정"
					onclick="document.location.href='updateForm.do?num=${article.num}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글삭제" onclick="document.location.href='deleteForm.do?num=${article.num}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="답글쓰기" onclick="document.location.href='writeUploadForm.do?num=${article.num}&ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}'">
					&nbsp;&nbsp;&nbsp;&nbsp; 
					<input type="button" value="글목록" onclick="document.location.href='list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>

