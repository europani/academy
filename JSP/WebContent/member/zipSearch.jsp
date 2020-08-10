<%@page import="member.ZipcodeBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="mMgr" class="member.MemberMgr" />
<%
	request.setCharacterEncoding("EUC-KR");
	String search = request.getParameter("search");
	String area3 = null;
	Vector<ZipcodeBean> vlist = null;
	if (search.equals("y")) {
		area3 = request.getParameter("area3");
		vlist = mMgr.zipcodeRead(area3);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body bgcolor="#FFFFCC">
	<div align="center">
	<br>
		<form name="zipFrm" method="post">
			<table>
				<tr>
					<td><br>���θ� �Է� : <input name="area3"><input type="button" value="�˻�" onclick="loadSearch()"></td>
				</tr>
				<%
					if (search.equals("y")) {
						if (vlist.isEmpty()) {
				%>
					<tr>
						<td align="center"><br>�˻��� ����� �����ϴ�.</td>
					</tr>
				<%
						} else {
				%>
					<tr>
						<td align="center"><br>�˻� ��, �Ʒ� �����ȣ�� Ŭ���ϸ� �ڵ����� �Էµ˴ϴ�.</td>
					</tr>
				<%
					for (int i = 0; i < vlist.size(); i++) {
						ZipcodeBean bean = vlist.get(i);
						String rZipcode = bean.getZipcode();
						String rArea1 = bean.getArea1();
						String rArea2 = bean.getArea2();
						String rArea3 = bean.getArea3();
						String adds = rArea1 + " " + rArea2 + " " + rArea3;
				%>
					<tr>
						<td><a href="#" onclick="sendAdd('<%=rZipcode %>', '<%=adds%>')"><%=rZipcode%> <%=adds %></a> </td>
					</tr>
				<%
					}
				
					}
				}
				%>
				<tr>
					<td align="center"><br>
					<a href="#" onclick="self.close()">�ݱ�</a>
					</td>
				</tr>
			</table>
			<input type="hidden" name="search" value="y">
		</form>
	</div>

<script type="text/javascript">
	function loadSearch() {
		frm = document.zipFrm;
		if (frm.area3.value == "") {
			alert("���θ��� �Է��ϼ���.");
			frm.area3.focus();
			return;
		}
		frm.action = "zipSearch.jsp";
		frm.submit();		
	}
	
	function sendAdd(zipcode, adds) {
		opener.document.regFrm.zipcode.value = zipcode;
		opener.document.regFrm.address.value = adds;
		self.close();
	}

</script>
</body>
</html>