<%@page import="db.BoardDTO"%>
<%@page import="db.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%
	int pageSize = 5;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	String category = request.getParameter("category");
	String sentence = request.getParameter("sentence");

	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage - 1) * pageSize + 1;
	int endRow = currentPage * pageSize;
	int count = 0;
	int number = 0;
	List articleList = null;
	BoardDAO dbPro = BoardDAO.getInstance();
	count = dbPro.getArticleCount(boardid, category, sentence);
	if (count > 0) {
		articleList = dbPro.getArticles(startRow, endRow, boardid, category, sentence);
	}
	number = count - (currentPage - 1) * pageSize;
%>
<p class="w3-left" style="padding-left: 30px;"><%=board%>>
</p>
<div class="w3-container">
	<span class="w3-center  w3-large">
		<h3><%=board%>(��ü ��:<%=count%>)
		</h3>
	</span>
	<p class="w3-right w3-padding-right-large">
		<a href="writeUploadForm.do">�۾���</a>
	</p>
	<%
		if (count == 0) {
	%>
	<table class="w3-table-all" width="700">
		<tr class="w3-grey">
			<td align="center">�Խ��ǿ� ����� ���� �����ϴ�.</td>
			</tr>
	</table>
	<%
		} else {
	%>
	<table class="w3-table-all" width="700">
		<tr class="w3-grey">
			<td align="center" width="50">��ȣ</td>
			<td align="center" width="250">�� ��</td>
			<td align="center" width="100">�ۼ���</td>
			<td align="center" width="150">�ۼ���</td>
			<td align="center" width="50">�� ȸ</td>
			<td align="center" width="100">IP</td>
		</tr>
		<%
			for (int i = 0; i < articleList.size(); i++) {
					BoardDTO article = (BoardDTO) articleList.get(i);
		%>
		<tr height="30">
			<td align="center" width="50"><%=number--%></td>
			<td width="250">
				<%
					int wid = 0;
							if (article.getRe_level() > 0) {
								wid = 5 * (article.getRe_level());
				%> <img src="<%=request.getContextPath() %>/images/level.gif" width="<%=wid%>" height="16"> <img
				src="<%=request.getContextPath() %>/images/re.gif"> <%
 	} else {
 %> <img src="<%=request.getContextPath() %>/images/level.gif"
				width="<%=wid%>" height="16">
				<%
					}
				%> <a href="content.jsp?num=<%=article.getNum()%>"> [<%=article.getNum()%>,<%=article.getRef()%>,
					<%=article.getRe_level()%>,<%=article.getRe_step()%>] <%=article.getSubject()%></a>
				<%
					if (article.getReadcount() >= 20) {
				%> <img src="<%=request.getContextPath() %>/images/hot.gif"
				border="0" height="16"> <%
 	}
 %>
			</td>
			<td align="center" width="100"><%=article.getWriter()%></td>
			<td align="center" width="150"><%=sdf.format(article.getReg_date())%></td>
			<td align="center" width="50"><%=article.getReadcount()%></td>
			<td align="center" width="100"><%=article.getIp()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<%
		}
	%>
	<div class="w3-center">
		<%
			int bottomLine = 3;
			if (count > 0) {
				int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
				int startPage = 1 + (currentPage - 1) / bottomLine * bottomLine;
				int endPage = startPage + bottomLine - 1;

				if (endPage > pageCount)
					endPage = pageCount;
				if (startPage > bottomLine) {
		%><a href="list.jsp?pageNum=<%=startPage - bottomLine%>">[����]</a>
		<%
			}
		%>
		<%
			for (int i = startPage; i <= endPage; i++) {
		%>
		<a href="list.jsp?pageNum=<%=i%>"> <%
 	if (i != currentPage)
 				out.print("[" + i + "]");
 			else
 				out.print("<font color='red'>[" + i + "]</font>");
 %></a>
		<%
			}
				if (endPage < pageCount) {
		%>
		<a href="list.jsp?pageNum=<%=startPage + bottomLine%>">[����]</a>
		<%
			}
			}
		%>
	</div>
	<div>
		<div class="w3-center">
			<form name="searchForm" method="post">
				<select name="category" size="1">
					<option value="writer">�� ��</option>
					<option value="subject">�� ��</option>
					<option value="content">�� ��</option>
				</select> <input size="16" name="sentence"> <input type="submit"
					value="ã��">
			</form>
		</div>
	</div>
</div>
</body>
</html>