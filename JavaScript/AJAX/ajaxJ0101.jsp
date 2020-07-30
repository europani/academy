<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<button>GET request</button>
<div id ="view"></div>
<script>
        $('button').click(function () {
            $.get("testJ0101.jsp", function (data, status) {
                alert('Data : ' + data + "\nStatus : " + status);
                $("#view").html(data);
            });
        });
    </script>

</body>
</html>