<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h2>Functions Tags</h2>
<c:set var="str" value="JSPStudy :: the whole new world!!" />
<hr width="430" align="left" color="red" />
str : <b>${str}</b><br>
length : <b>${fn:length(str)}</b><br>
substring : <b>${fn:substring(str, 0, 8)}</b><br>
substringAfter : <b>${fn:substringAfter(str, "JSPStudy")}</b><br>
substringBefore : <b>${fn:substringBefore(str, "the")}</b><br>
toUpperCase : <b>${fn:toUpperCase(str)}</b><br>
tolowerCase : <b>${fn:toLowerCase(str)}</b><br>
replace : <b>${fn:replace(str, "JSP", "Android")}</b><br>
indexOf : <b>${fn:indexOf(str, "the")}</b><br>
startWith : <b>${fn:startsWith(str, "JSPStudy")}</b><br>
endWith : <b>${fn:endsWith(str, "JSPStudy")}</b><br>
contains : <b>${fn:contains(str, "jspstudy")}</b><br>
containsIgnoreCase : <b>${fn:containsIgnoreCase(str, "jspstudy")}</b><br>
trim : ***<b>${fn:trim("    http://JSPStudy.co.kr     ")}</b>***<br>
<c:set var="arr" value="${fn:split(str, ' ')}" />
join : <b>${fn:join(arr, "&&")}</b>

</body>
</html>