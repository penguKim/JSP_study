<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>responseResult2.jsp</h1>
	<h1>로그인 실패 시 응답 페이지</h1>
	<script>
// 		alert("로그인 실패!");
// 		history.back(); // 이전 페이지로 돌아가기 (입력 결과가 남아있음)
		location.href = "request4Form.jsp"; // 로그인 페이지 새로 요청하기
	</script>
</body>
</html>