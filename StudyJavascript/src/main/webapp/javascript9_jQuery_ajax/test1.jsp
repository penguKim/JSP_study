<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
	/*
	AJAX(Asynchonous Javascript And Xml, 비동기식 자바스크립트&XML)
	- 웹 페이지(브라우저)의 갱신(Refresh) 없이도 서버로 요청을 수행하고 
	  요청에 대한 응답을 처리할 수 있는 자바스크립트(jQuery) 라이브러리
	- 데이터베이스 등의 작업 요청 시 요청된 응답이 돌아올 때까지 기다리지 않고
	  다른 작업을 수행하면서 요청에 대한 응답이 돌아오면 해당 응답을 처리하는 기술
	- 주로, 아이디 및 패스워드 검증 등의 실시간 정보 조회 작업에 활용
	- jQuery 의 라이브러리로 제공
	
	< 기본 문법 >
	jQuery와 AJAX 에서는 속성과 :을 붙여서 사용하는걸 추천한다.
	
	$.ajax({
		type: xxx, // AJAX 로 요청 시 사용할 메서드(= 요청 방식 = "GET" or "POST" 등) 지정
		url: xxx, // AJAX 로 요청할 요청 주소(URL)
		data: xxx, // 요청(전송할) 데이터 지정(복수개 파라미터일 경우 중괄호로 묶고, 속성명 : 값 형식으로 지정)
		dataType: xxx, // 응답 데이터에 대한 타입 지정(생략 시 "text")
		success: function(response) { // 요청에 대한 처리 성공 시 처리할 함수 정의
			
		}, 
		error : function(xhr, textStatus, errorThrown) { // 요청에 대한 처리 실패 시 처리할 함수 정의
			
		}
	});
	----------------------------------------------------------
	요청에 대한 응답이 있어야 그다음 요청이 수행되는것이 동기식이다.
	
	*/
	// -------------------------------------------------------------
	// 로그인 버튼 클릭 이벤트 처리
	$(function() {
		$("#btnLogin").on("click", function(){
			// 아이디, 패드워드 중 하나라도 입력되지 않았을 경우 오류메세지 출력하고 함수 종료
			if($("#id").val() == "") {
				alert("아이디 입력 필수!");
				$("#id").focus();
				return;
			} else if($("#passwd").val() == "") {
				alert("비밀번호 입력 필수!");
				$("#passwd").focus();
				return;
			}
// 			$("form").submit(); // 폼에 대한 submit 동작 수행(동기식 방식)
			// -----------------------------------
			// AJAX 를 사용하여 test1_result.jsp 페이지로 요청 전송하기
			// => 이때, 파라미터로 아이디와 패스워드를 함께 전달(GET 방식)
			
			$.ajax({
				type: "POST", // 요청 방식을 POST 방식으로 지정
// 				url: "test1_result.jsp", // AJAX 로 서버에 요청할 요청 주소(URL)
				url: "http://localhost:8080/MVC_Board/MemberLoginPro.me", // 서블릿 주소 요청도 가능
// 				data: "xxx", // 전송할 데이터가 단일 항목일 경우 데이터 직접 지정
// 				data: { // 전송할 데이터가 복수개일 경우 중괄호로 묶기
// 					// 폼 데이터 또는 자바스크립트 변수 등을 가져와서 파라미터로 표현(전송)하는 경우
// 					// 파라미터명 : 데이터 형식으로 지정
// 					// -------- 값을 직접 지정 시 ---------
// // 					id : "hong",
// // 					passwd : "1234"
// 					// -------- 입력폼에서 값을 가져와서 전달 시 ---------
// 					id : $("#id").val(), // id 선택자의 value 속성값을 id 파라미터로 저장
// 					passwd : $("#passwd").val() // passwd 선택자의 value 속성값을 passwd 파라미터로 저장
// 				},
				// -------- 입력폼에서 값을 한꺼번에 가져와서 전달 시 ---------
				// 폼 객체 지정하여 serialize() 메서드 호출하여 폼 파라미터 묶음 처리
				data: $("form").serialize(), // 파라미터를 변수에 저장 후 사용도 가능
				success: function(response) { // 요청 처리 성공 시 자동으로 호출되는 콜백(Callback) 함수
					// 익명 함수 파라미터로 응답데이터가 전달됨(처리하는 페이지에서 응답한 결과물)
					// id 선택자 "resultArea" 영역에 응답데이터(response) 출력하기
					$("#resultArea").html(response);
				},
				error: function(e) { // 요청 처리 실패(= 에러 발생) 시 자동으로 호출되는 콜백 함수
					$("#resultArea").html("에러 : " + e);
				}
			});
			
		});
		
	});
</script>
</head>
<body>
	<div align="center">
		<h1>로그인</h1>
		<form action="" method="post">
			<input type="text" placeholder="아이디" name="id" id="id"><br>
			<input type="password" placeholder="패스워드" name="passwd" id="passwd"><br>
			<input type="button" value="로그인" id="btnLogin">
		</form>
		<hr>
		<h1>응답 처리 결과</h1>
			<div id="resultArea"><!-- AJAX 요청에 대한 응답 처리 결과를 출력할 위치 --></div>
	</div>
</body>
</html>