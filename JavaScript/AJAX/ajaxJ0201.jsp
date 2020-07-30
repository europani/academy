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
<form name='ajaxForm'>
<input type="text" name="name">
<input type="text" name="city">
</form>
<div id="view"></div>
<button>POST request</button>
<script>
        $('button').click( function () {
            let queryString = $('form[name=ajaxForm]').serialize();
            console.log(queryString);
            $.ajax({
                type : 'post',
                url : 'testJ0201.jsp',
                data : queryString,
                error : function (xhr, status, error) {   alert(error);          },
                success : function (data, status) {
                    alert('Data : ' + data + '\nStatus : ' + status);
                    $('#view').html(data);
                }

            });
        });

    </script>
</body>
</html>