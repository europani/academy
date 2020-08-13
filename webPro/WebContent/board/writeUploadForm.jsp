<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%><html>
<head>
<title>게시판</title>
</head>
<%
	int num = 0, ref = 1, re_step = 0, re_level = 0;
%>
<p class="w3-left" style="padding-left: 30px;"></p>
<div class="w3-container">
	<b>글쓰기</b><br>
	
	<form method="post" name="writeform" enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/board/writeUploadPro.jsp">		<!-- request.getContextPath() : 프로젝트명 -->
		<input type="hidden" name="num" value="<%=num%>">
		<input type="hidden" name="ref" value="<%=ref%>">
		<input type="hidden" name="re_step" value="<%=re_step%>">
		<input type="hidden" name="re_level" value="<%=re_level%>">
		
		<table class="w3-table-all" style="width: 70%;">

			<tr>
				<td align="right" colspan="2"><a
					href="<%=request.getContextPath()%>/board/list.jsp"> 글목록</a></td>
			</tr>
			<tr>
				<td width="70" align="center">이 름</td>
				<td width="330"><input type="text" size="10" maxlength="10"
					name="writer"></td>
			</tr>
			<tr>
				<td width="70" align="center">제 목</td>
				<td width="330">
					<input type="text"
					size="40" maxlength="50" name="subject"> 
				</td>
			</tr>
			<tr>
				<td width="70" align="center">Email</td>
				<td width="330"><input type="text" size="40" maxlength="30"
					name="email"></td>
			</tr>

			<tr>
				<td width="70" align="center">내 용</td>
				<td width="330"><textarea name="content" rows="13" cols="40"></textarea>
				</td>
			</tr>
		    <tr>
				<td width="70" align="center">file</td>
				<td width="330"><input type="file" size="40" maxlength="30"
					name="uploadfile"></td>
			</tr>
		<tr>
				<td width="70" align="center">비밀번호</td>
				<td width="330"><input type="password" size="8" maxlength="12" name="passwd"></td>
			</tr>
			<tr>
				<td colspan=2 align="center"><input type="submit" value="글쓰기">
					<input type="reset" value="다시작성"> 
					<input type="button" value="목록보기" OnClick="window.location='<%=request.getContextPath()%>/board/list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

