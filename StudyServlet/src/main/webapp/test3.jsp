<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<!-- "myServlet3" 서블릿 요청에 대해 TestMyServlet3 클래스 실행 -->
	<form action="myServlet3" method="get">
		<input type="submit" value="myServlet3 서블릿 주소 요청(GET)">
	</form>
	 
	<form action="myServlet3" method="post">
		<input type="submit" value="myServlet3 서블릿 주소 요청(POST)">
	</form>
	
	<hr>
	
	<form action="myServlet4" method="get">
		<input type="submit" value="myServlet4 서블릿 주소 요청(GET)">
	</form>
	 
	<form action="myServlet4" method="post">
		<input type="submit" value="myServlet4 서블릿 주소 요청(POST)">
	</form>
</body>
</html>