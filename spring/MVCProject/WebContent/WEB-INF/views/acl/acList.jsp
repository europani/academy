<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${project}</title>
</head>
<body>
<form action="<c:url value='/acl/modify' />" method="post">
<table border="1">
	<tr>
		<td>ID</td> <td>읽기</td> <td>생성</td> <td>수정</td> <td>삭제</td> <td>사용안함</td>
	</tr>
	<c:forEach var="perm" items="${aclList }" varStatus="status">
		<tr>
			<td>${perm.id}<input type="hidden" name="perm[${status.index }].id" value="${perm.id }"> </td>
			<td><input type="checkbox" name="perm[${status.index }].canRead" value="true" ${perm.canRead ? 'checked' : ''}> </td>
			<td><input type="checkbox" name="perm[${status.index }].canCreate" value="true" ${perm.canCreate ? 'checked' : ''}> </td>
			<td><input type="checkbox" name="perm[${status.index }].canModify" value="true" ${perm.canModify ? 'checked' : ''}> </td>
			<td><input type="checkbox" name="perm[${status.index }].canDelete" value="true" ${perm.canDelete ? 'checked' : ''}> </td>
			<td><input type="checkbox" name="perm[${status.index }].removed" value="true" ${perm.removed ? 'checked' : ''}> </td>
		</tr>
	</c:forEach>
	<tr>
		<td colspan="6"><input type="submit" value="수정"></td>
	</tr>
</table>
</form>
</body>
</html>