<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.7.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnOk").on("click", function() {
			/*
			영화진흥위원회 오픈API 를 활용하여 영화 정보 JSON 데이터 처리
			https://www.kobis.or.kr/kobisopenapi/homepg/main/main.do
			-------------------------------------------------------------
			일별 박스오피스 목록 조회 후 테이블에 표시
			https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchDailyBoxOffice
			=> 지정된 요청 파라미터 형식에 맞게 URL 을 수정해야함
			
			샘플 API 요청 주소(단, 대상 조회일자(targetDt)는 어제(2023년 12월 5일로 변경))
			http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20231205
			*/
			$.ajax({
				type: "GET", // 생략 가능
				url: "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20231205", 
				dataType: "json", // 응답 데이터를 JSON 객체로 취급 
				success: function(data) {
// 					$("#resultArea").html(JSON.stringify(data));
					$("#resultArea").html(data.boxOfficeResult.dailyBoxOfficeList[0].movieNm);
					
				},
				error : function() {
					$("#resultArea").html("AJAX 요청 실패!");
				}
			}); // ajax 요청 끝
			
		}); // 버튼 클릭 이벤트 끝
	}); // document.ready 이벤트 끝
</script>
</head>
<body>
	<h1>AJAX - test5_json.jsp</h1>
	<input type="button" value="일별 박스오피스 조회" id="btnOk">
	<hr>
	<div id="resultArea"></div>
	<hr>
	<div id="resultArea2"></div>
</body>
</html>











