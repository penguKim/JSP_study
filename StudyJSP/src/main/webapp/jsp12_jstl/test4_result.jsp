<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test4_result.jsp - JSTL</h1>
	<%--
	request 객체에 저장된 속성값 꺼낼 때 request.getAttribute() 메서드 사용했으나
	EL 문법은 ${영역객체명.속성명} 형식으로 꺼낼 수 있다!
	=> 이 때, 영역객체명은 생략 가능하며 page -> request -> session -> application 영역을
	   차례대로 검사하여 일치하는 속성에 접근한다!
	=> 주의! 파라미터는 ${param.파라미터명} 이고, 속성은 ${속성명} 형식 사용
	--%>
	<h3>
		번호 : ${idx }<br>
		이름 : ${name }
		
	</h3>
	
</body>
</html>















