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
		
		<li><a href="files/a123">/files/a123</a>: @PathVariable 정규표현식, FileController.fileInfo()</li>
		<li><a href="files/a1">/files/a1</a>: @PathVariable 정규표현식 404, FileController.fileInfo()</li>
		<li><a href="folders/1/2/3/files">/folders/1/2/3/files</a>: @RequestMapping Ant패턴, FileController.list()</li>		
	</ul>
</li>
<li>요청 파라미터 처리 :
	<ul>
		<li><a href="event/detail?id=1">event/detail?id=1</a>: HttpServletRequest를 이용한 파라미터 구하기, EventController.detail()</li>
		<li><a href="event/detail2?id=1">event/detail2?id=1</a>: @Requestparam을 이용한 파라미터 구하기, EventController.detail2()</li>
		<li><a href="event/detail2?id=1">event/detail2</a>: @Requestparam을 필수 파라미터 400 에러, EventController.detail2()</li>
		<li><a href="search">search</a>: @Requestparam을 필수 아님 설정, SearchController.search()</li>
		<li><a href="search?q=3">search?q=3</a>: @Requestparam을 필수 아님 설정, SearchController.search()</li>
		<li><a href="search2">search2</a>: @Requestparam을 필수 아님 설정, SearchController.search2()</li>
	</ul>	
</li>
</body>
</html>