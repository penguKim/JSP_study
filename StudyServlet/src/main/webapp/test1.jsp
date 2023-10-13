<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>
	<!-- 
	지금까지 요청 주소를 특정 파일(xxx.jsp)명을 사용했으나
	서블릿 주소는 특정 파일의 이름이 아닌 가상의 주소를 요청 주소로 사용
	--------------------------------------------------------------------
	서블릿 요청 방식(GET ot POST) 중 
	POST 방식 요청은 form 태그 내에 method="post" 를 명시해야하며
	그 외의 대부분의 요청 방식은 모두 GET 방식 요청으로 취급된다! 
	-->
	 
	 <!-- 하이퍼링크 사용하여 GET 방식으로 "myServlet" 서블릿 주소 요청 -->
	 <a href="myServlet">myServlet 서블릿 주소 요청(GET)</a>
	 
	 <!-- from 태그를 사용하여 GET 방식과 POST 방식으로 각각 "myServlet" 서블릿 주소 요청 -->
	 <form action="myServlet" method="get">
	 	<input type="submit" value="myServlet 서블릿 주소 요청(GET)">
	 </form>
	 
	 <!-- 요청 방식에 대해 일치하는 메서드(doPost()) 가 없을 경우 HTTP 405 에러 발생! -->
	 <form action="myServlet" method="post">
	 	<input type="submit" value="myServlet 서블릿 주소 요청(POST)">
	 </form>
	 
	 <!-- 매핑되지 않은 서블릿 주소 요청 시 404 에러 발생 -->
	 <form action="myServlet_fail" method="post">
	 	<input type="submit" value="myServlet_fail 서블릿 주소 요청(실패)">
	 </form>
	 
	 
	 
</body>
</html>