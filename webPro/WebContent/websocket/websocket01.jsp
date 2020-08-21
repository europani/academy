<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% if (session.getAttribute("idKey") == null) {%>
<script>
	alert('로그인을 하세요');
</script>
<% } else {
	String name = (String) session.getAttribute("idKey");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Testing webSockets</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
	#me {
		position: relative;
		left: 100px;
		min-width: 100px;
		max-width: 400px;
	}
	#you {
		position: relative;
		left: 10px;
		min-width: 100px;
		max-width: 400px;
	}
</style>
</head>
<body>
	<fieldset>
		<div class="w3-pale-yellow" id="messageWindow" style="width:500px; height: 300px; border: 1px solid grey; overflow: auto;"></div>
		<br>
		<input id="inputMessage" type="text" onkeypress="enterKey(event)" />
		<input type="submit" value="send" onclick="send()">
	</fieldset>
</body>
<script type="text/javascript">
	let textarea = document.querySelector("#messageWindow");
	let webSocket = new WebSocket('ws://211.63.89.82:8089<%=request.getContextPath()%>/weball');
	let inputMessage = document.querySelector("#inputMessage");
	
	webSocket.onerror = function (event) {
		onError(event);
	}
	webSocket.onopen = function (event) {
		onOpen(event);
	}
	webSocket.onmessage = function (event) {
		onMessage(event);
	}
	
	function onMessage(event) {
		textarea.innerHTML += "<div id='you' class='w3-white w3-border w3-round-large w3-padding-small' style='width:" + (event.data.length*12) + "px;'>" 
						+ event.data + "</div><br>";
		textarea.scrollTop = textarea.scrollHeight;
	}

	function onOpen(event) {
		textarea.innerHTML += "연결성공<br>";
		webSocket.send("<%=name%>: 입장하였습니다.");
	}
	
	function onError(event) {
		alert(event.data);
	}
	
	function send() {
		textarea.innerHTML += "<div id='me' class='w3-yellow w3-border w3-round-large w3-padding-small' style='width:"
						+ (inputMessage.value.length*12) + "px;'>나: " + inputMessage.value + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div><br>";
		textarea.scrollTop = textarea.scrollHeight;
		webSocket.send("<%=name%>: " + inputMessage.value);
		inputMessage.value = "";
	}
	
	function enterKey(e) {
		if (e.keyCode == 13) {
			send();
		}
	}
</script>
</html>
<% } %>