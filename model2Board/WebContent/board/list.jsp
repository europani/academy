<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="w3-left" style="padding-left: 30px;">${board}></p>
<div class="w3-container">
	<span class="w3-center  w3-large">
		<h3>${board}(��ü��:${count})</h3>
	</span>
	<p class="w3-right w3-padding-right-large">
		<a href="writeUploadForm.do">�۾���</a>
	</p>
	<c:if test="${count == 0}">
		<table class="w3-table-all" width="700">
			<tr class="w3-grey">
				<td align="center">�Խ��ǿ� ����� ���� �����ϴ�.</td>
			</tr>
		</table>
	</c:if>
	<c:if test="${count != 0}">
		<table class="w3-table-all" width="700">
			<tr class="w3-grey">
				<td align="center" width="50">��ȣ</td>
				<td align="center" width="250">�� ��</td>
				<td align="center" width="100">�ۼ���</td>
				<td align="center" width="150">�ۼ���</td>
				<td align="center" width="50">�� ȸ</td>
				<td align="center" width="100">IP</td>
			</tr>
			<c:set var="number" value="${number}" />
			<c:forEach var="article" items="${articleList}">
			<tr height="30">
				<td align="center" width="50">${number }</td>
				<c:set var="number" value="${number-1}" />
				<td width="250">
				<c:if test="${article.re_level > 0}">
					<img src="<%=request.getContextPath() %>/images/level.gif" width="${5 * (article.re_level) }" height="16"> 
					<img src="<%=request.getContextPath() %>/images/re.gif"> 
				</c:if>
				<c:if test="${article.re_level == 0}">
				 	<img src="<%=request.getContextPath() %>/images/level.gif" width="${5 * (article.re_level) }" height="16"> 
				</c:if>
				<a href="content.do?num=${article.num}"> [${article.num},${article.ref},
						${article.re_level},${article.re_step}] ${article.subject}</a>
				<c:if test="${article.readcount} >= 20">
					<img src="<%=request.getContextPath() %>/images/hot.gif" border="0" height="16"> 
 				</c:if>
				</td>
				<td align="center" width="100">${article.writer}</td>
				<td align="center" width="150">${article.reg_date}</td>
				<td align="center" width="50">${article.readcount}</td>
				<td align="center" width="100">${article.ip}</td>
			</tr>
		</c:forEach>
		</table>
	
	<div class="w3-center">
	<c:if test="${startPage > bottomLine }">
		<a href="list.do?pageNum=${startPage - bottomLine}">[����]</a>
	</c:if>
	<c:forEach var="i" begin="${startPage}" end="${endPage}">
		<a href="list.do?pageNum=${i}">
			<c:if test="${i != currentPage}">[${i}]</c:if>
			<c:if test="${i == currentPage}"><font color='red'>[${i}]</font></c:if>
 		</a>
 	</c:forEach>
 	<c:if test="${endPage < pageCount}">
		<a href="list.do?pageNum=${startPage + bottomLine}">[����]</a>
	</c:if>
	</div>
	<div>
		<div class="w3-center">
			<form name="searchForm" method="post">
				<select name="category" size="1">
					<option value="writer">�� ��</option>
					<option value="subject">�� ��</option>
					<option value="content">�� ��</option>
				</select> <input size="16" name="sentence"> 
				<input type="submit" value="ã��">
			</form>
		</div>
	</div>
	</c:if>
</div>
</body>
</html>