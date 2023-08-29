<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 결과</h1>
	<h3>입력받은 아이디 : ${param.id }</h3>
	<h3>입력받은 비밀번호 : ${param.passwd }</h3>
	<h3>로그인 상태유지 여부 : ${param.rememberLogin }</h3>
</body>
</html>