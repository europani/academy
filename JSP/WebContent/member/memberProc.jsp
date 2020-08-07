<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="bean" class="member.MemberBean" />
<jsp:setProperty name="bean" property="*" />
<%=bean %>
