<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
</head>
<body>
    <form name="search">
    <div style="left : 50%; top : 50%;"></div>
        <input type="text" name="keyword" id="keyword" onkeydown="startSuggest()" />
        <input type="button" value="search" />
        <div id="suggest" style="display:; position: absolute; left: 0px; top: 30px;">
        <div id="suggestList"></div>
        </div>
    </form>
    
    <script>
        let checkFirst = false;
        let lastKeyword = '';
        let loopSendKeyword = false;

        function startSuggest() {   
            if (checkFirst == false) {
                setTimeout("sendKeyword();", 500);
                loopSendKeyword = true;
            }
            checkFirst = true;
        }

        function sendKeyword() {
            if (loopSendKeyword == false) {
                return;
            }
            let keyword = document.search.keyword.value;
            if (keyword == '') {        
                lastKeyword = '';
                hide('suggest');
            } else if (keyword != lastKeyword) {    
                lastKeyword = keyword;  
                if (keyword != '') {                 
                    let params = "keyword=" + encodeURIComponent(keyword);
                    sendRequest("command.jsp", params, displayResult, "POST");
                } else {
                    hide('suggest');
                }
            }
            setTimeout("sendKeyword();" , 500)
        }

        function displayResult() {
            if (httpRequest.readyState == 4) {
                if (httpRequest.status == 200) {
                    let resultText = httpRequest.responseText;
                    let listView = document.querySelector('#suggestList');
                    listView.innerHTML = httpRequest.responseText;
                    show('suggest');
                 } else {
                    alert("에러 : " + httpRequest.status);
                }
            }
        }   
        function show(elementId) {
            let element = document.querySelector('#elementId');
            if (element) {
                element.style.display = '';
            }

        }
        function hide(elementId) {
            let element = document.querySelector('#elementId');
            if (element) {
                element.style.display = 'none';
            }
        }


    </script>
</body>
</html>