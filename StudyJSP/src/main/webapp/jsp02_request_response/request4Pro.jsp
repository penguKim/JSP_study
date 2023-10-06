<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>request4Pro.jsp - 로그인 처리</h1>
	<%
	// request4Form.jsp 페이지로부터 전달받은 아이디, 패스워드 가져와서 변수에 저장 및 출력
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	/*
	[ 자바 코드를 사용하여 아이디, 패스워드 판별 ]
	- 데이터베이스에 저장된 아이디를 "admin" 이라고 가정하고, 패스워드를 "1234" 라고 가정
	- 폼을 통해 입력받은 아이디와 패스워드를 각각 데이터베이스 데이터와 비교하여
	  둘 다 일치할 경우 request4Pro_responseResult1.jsp 페이지로 리다이렉트, 
	  아니면 request4Pro_responseResult2.jsp 페이지로 리다이렉트
	*/
	String dbId = "admin";
	String dbPasswd = "1234";
	if(id.equals(dbId) && passwd.equals(dbPasswd)) {
		response.sendRedirect("request4Pro_responseResult1.jsp");
	} else {
		response.sendRedirect("request4Pro_responseResult2.jsp");
	}
	%>
</body>
</html>