<%@page import="boardold.BoardDto"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <jsp:useBean id="bDao" class="boardold.BoardDao"></jsp:useBean>
 <%
 	request.setCharacterEncoding("EUC-KR");
 
 	int totalRecord = 0;		// 전체 레코드수
 	int numPerPage = 10;		// 페이지당 레코드수
 	int pagePerBlock = 15;		// 블럭당 페이지수
 	
 	int totalPage = 0;
 	int totalBlock = 0;
 	
 	int nowPage = 1;
 	int nowBlock = 1;
 	int start = 0;				// DB select 시작번호
 	int end = numPerPage;		// 시작번호로부터 가져올 select수;   end = start + end; between start and end;
 	
 	int listSize = 0;
 	String keyWord = "", keyField = "";		// 검색
 	
 	ArrayList<BoardDto> list = null;
 	if (request.getParameter("keyWord") != null) {
 		keyWord = request.getParameter("keyWord");
 		keyField = request.getParameter("keyField");
 	} if (request.getParameter("reload") != null) {
 		if (request.getParameter("reload").equals("true")) {
 			keyWord = "";
 			keyField = "";
 		}
 	}
 	
 	if (request.getParameter("nowPage") != null) {
 		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	}
 	start = (nowPage * numPerPage) - numPerPage;
 	end = numPerPage;
 	
 	totalRecord = bDao.getTotalCount(keyField, keyWord);
 	totalPage = (int)Math.ceil((double)totalRecord / numPerPage);	// 전체페이지수
 	nowBlock = (int)Math.ceil((double)nowBlock / pagePerBlock);		// 현재블럭수
 	totalBlock = (int)Math.ceil((double)totalPage / pagePerBlock);	// 전체블럭수
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>JSPBoard</title>
<link href="style.css" rel="stylesheet">
<script type="text/javascript">
	function list() {
		document.listFrm.action = "list.jsp";
		document.listFrm.submit();
	}
	
	function pageing(page) {
		document.readFrm.nowPage.value = page;
		document.readFrm.submit();
	}
	
	function block(value) {
		document.readFrm.nowPage.value = <%=pagePerBlock%>*(value-1)+1;
		document.readFrm.submit();
	}
	
	function read(num) {
		document.readFrm.num.value=num;
		document.readFrm.action="read.jsp";
		document.readFrm.submit();
	}
	
	function check() {
		if (document.searchFrm.keyWord.value=="") {
			alert("검색어를 입력하세요.");
			document.searchFrm.keyWord.focus();
			return;
		}
		document.searchFrm.submit();
	}

</script>
</head>
<body bgcolor="#FFFFCC">
<div align="center">
	<br>
	<h2>JSPBoard</h2>
	<br>
	<table align="center" border="0" width="80%">
		<tr>	
			<td>
				Total : <%=totalRecord %>Articles(<font color="red"><%=nowPage%>/<%=totalPage%>Pages</font>)
			</td>
		</tr>
	</table>
	<table align="center" border="0" width="80%" cellspacing="0" cellpadding="3">
		<tr>
			<td align="left" colspan="2">
			<%
				list = bDao.getBoardList(keyField, keyWord, start, end);
				listSize = list.size();
				if (list.isEmpty()) {
					out.println("등록된 게시물이 없습니다.");
				} else {
			%>
				<table border="0" width="100%" cellspacing="0" cellpadding="2">
					<tr align="center" bgcolor="#D0D0D0" height="120%">
						<td>번 호</td>
						<td>제 목</td>
						<td>이 름</td>
						<td>날 짜</td>
						<td>조회수</td>					
					</tr>
			<%
					for (int i = 0; i < numPerPage; i++) {
						if (i == listSize) break;
						BoardDto dto = list.get(i);
						int num = dto.getNum();
						String name = dto.getName();
						String subject = dto.getSubject();
						String regdate = dto.getRegdate();
						int depth = dto.getDepth();
						int count = dto.getCount();
			%>
					<tr>
						<td align="center">
							<%=totalRecord-((nowPage-1)*numPerPage)-i %>	<!--   total - page당 게시글수-->
						</td>
						<td>
						<%
							if (depth > 0) {
								for (int j = 0; j<depth; j++) {
									out.println("&nbsp;&nbsp;");
								}
							}
						%>
						<a href="javascript:read('<%=num%>')"><%=subject%></a>
						</td>
						<td align="center"><%=name %></td>
						<td align="center"><%=regdate %></td>
						<td align="center"><%=count %></td>
					</tr>
			<%
					}
			%>
				</table>
			<%		
				}
			%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><br><br></td>
		</tr>
		<tr>
			<td>
				<%
					// 페이징 및 블럭 처리
					int pageStart = (nowBlock-1)*pagePerBlock + 1;
					int pageEnd = ((pageStart+pagePerBlock) < totalPage)? (pageStart + pagePerBlock) : totalPage+1;
				
					if (totalPage != 0) {
						if (nowBlock > 1) {
				%>
			
						<a href="javascript:block('<%=nowBlock-1%>')">prev...</a>
				<%		
						}
				%>	&nbsp;
				<%
					for (; pageStart < pageEnd; pageStart++) {
				%>
					<a href="javascript:pageing('<%=pageStart%>')">
				<%
					if (pageStart == nowPage) {
				%>
					<font color="blue">
				<%		
					}
				%>
					[<%=pageStart %>]
				<%
					if (pageStart == nowPage) {
				%>
					</font>
				<%		
					}
				%>
					</a>
				<%		
					}
				%> &nbsp;
				<%
					if (totalBlock > nowBlock) {
				%>
					<a href="javascript:block('<%=nowBlock+1%>')">.....next</a>
				<%		
					}
				%>
					&nbsp;
				<%
					}
				%>
			</td>
			<td align="right">
				<a href="post.jsp">[글쓰기]</a>
				<a href="javascript:list()">[처음으로]</a>
			</td>
		</tr>
	</table>
<hr width="80%" />
<form name="searchFrm" method="post" action="list.jsp">
	<table border="0" width="527" align="center" cellspacing="0" cellpadding="4">
		<tr>
			<td align="center" valign="bottom">
				<select name="keyField" size="1">
					<option value="name">이 름</option>
					<option value="subject">제 목</option>
					<option value="content">내 용</option>
				</select>
			<input size="16" name="keyWord">
			<input type="button" value="찾기" onclick="javascript:check()">
			<input type="hidden" name="nowPage" value="1">
			</td>
		</tr>
	</table>
</form>
<form name="listFrm" action="post">
	<input type="hidden" name="reload" value="true">
	<input type="hidden" name="nowPage" value="1">
</form>
<form name="readFrm" action="get">
	<input type="hidden" name="num">
	<input type="hidden" name="nowPage" value="<%=nowPage%>">
	<input type="hidden" name="keyField" value="<%=keyField%>">
	<input type="hidden" name="keyWord" value="<%=keyWord%>">
</form>
</div>
</body>
</html>