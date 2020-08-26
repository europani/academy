<%@page import="el.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${vals = [20, 17, 30, 2, 9, 23];
	sortedVals = vals.stream().sorted().toList() }
<hr>
${vals = [20, 17, 30, 2, 9, 23];
	sortedVals = vals.stream().sorted((x1, x2) -> x1 < x2 ? 1 : -1).toList() }
<hr>
<%
	List<Member> memberList = Arrays.asList(
			new Member("홍길동", 20),
			new Member("이순신", 54),
			new Member("유관순", 19),
			new Member("왕건", 42)
			);
	request.setAttribute("members", memberList);
%>
${sortedMem = members.stream().sorted((m1, m2) -> m1.age.compareTo(m2.age)).toList();'' }
${sortedMem}
</body>
</html>