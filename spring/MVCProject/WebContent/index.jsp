<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<li>헬로우 월드 : 
	<ul>
		<li><a href="hello.do">/hello.do</a> : 스프링MVC 일단 해보기 HelloController</li>
		<li><a href="hello2.do">/hello2.do</a> : 스프링MVC 일단 해보기 HelloController</li>
		<li><a href="hello.nhn">/hello.nhn</a> : 스프링MVC 일단 해보기 HelloController2</li>
	</ul>
</li>
<li>모델 : 
	<ul>
		<li><a href="event/list">/event/list</a>: Model 예시, EventController.list()</li>
		<li><a href="event/list2">/event/list2</a>: ModelAndView 예시, EventController.list2()</li>
	</ul>
</li>
<li>@RequestMapping, @PathVariable :
	<ul>
		<li><a href="member/regist">/member/regist</a>: GET/POST 예, RegistrationControler</li>
		<li><a href="members">/members</a>: @PathVariable 사용 위한 목록 추루력, MemberController.members()</li>
		
		
		<li><a href="members/m2">/members/m2</a>: @PathVariable 예, MemberController.memberDetail()</li>
		<li><a href="members/m2/orders">/members/m2/orders</a>: @PathVariable 예, MemberController.memberDetail()</li>
		<li><a href="members/m2/orders/1">/members/m2/orders/1</a>: @PathVariable 예, MemberController.memberDetail()</li>
		<li><a href="members/m2/orders/1a">/members/m2/orders/1a</a>: @PathVariable 400 응답 예, MemberController.memberDetail()</li>
	</ul>
</li>
</body>
</html>