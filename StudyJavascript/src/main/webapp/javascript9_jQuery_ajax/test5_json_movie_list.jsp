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
					// 임시) #resultArea 영역에 응답 데이터 출력
// 					$("#resultArea").html(JSON.stringify(data)); // 단순 문자열
					// 단순 파싱
// 					$("#resultArea").html(data.boxOfficeResult.dailyBoxOfficeList[0].movieNm);
					// ----------------------------------------------------------------------
					// 응답 데이터(박스오피스 목록) 객체(data)로부터 박스오피스 정보 추출하기
					// => 전체 데이터가 하나의 객체({})로 묶여있음
					// 1. 박스오피스 전체 데이터가 저장된 "boxOfficeResult" 객체 추출
					let boxOfficeResult = data.boxOfficeResult;
// 					console.log("boxOfficeResult : " + boxOfficeResult); // [object Object]
// 					console.log("boxOfficeResult : " + JSON.stringify(boxOfficeResult)); // 문자열 출력
					
					// 2. 박스오피스 타입("boxofficeType")과 조회날짜범위("showRange") 추출
					// => 1번에서 추출한 boxOfficeResult 객체를 통해 접근
					let boxofficeType = boxOfficeResult.boxofficeType;
					let showRange = boxOfficeResult.showRange;
// 					console.log(boxofficeType + ", " + showRange);
					// 테이블 바깥쪽 상단부에 2번 추출 결과 출력할 경우 => before 또는 prepend
					// showRange의 데이터는 "날짜~날짜" 이므로 구분자로 잘라서 사용도 가능하다.
					$("#resultArea").prepend("<h3>" + boxofficeType + "(" + showRange.split("~")[0] + ")</h3>");
					
					// 3. 일별 박스오피스 목록("dailyBoxOfficeList") 추출
					// => 복수개의 영화정보 객체{}가 dailyBoxOfficeList 라는 배열[]로 관리됨
					// => 단, 배열 내의 데이터가 객체로 이루어져있으므로 별도의 처리 추가 필요
					let dailyBoxOfficeList = boxOfficeResult.dailyBoxOfficeList;
// 					console.log("dailyBoxOfficeList : " + JSON.stringify(dailyBoxOfficeList));

					// 4. 추출된 박스오피스 목록(배열)을 반복문을 통해 차례대로 접근하여
					//    현재순위(rank), 제목(movieNm), 개봉일(openDt), 누적관객수(audiAcc)
					//    추출 후 테이블 내에 출력
					for(let movie of dailyBoxOfficeList) {
						let rank = movie.rank;
						let movieNm = movie.movieNm;
						let openDt = movie.openDt;
						let audiAcc = movie.audiAcc;
						$("table").append("<tr><td>" + rank + "</td>"
										+ "<td>" + movieNm + "</td>"
										+ "<td>" + openDt + "</td>"
										+ "<td>" + audiAcc + "</td></tr>"
										);
					}
					
					
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
	<div id="resultArea">
		<table border="1">
			<tr>
				<th width="80">현재순위</th>
				<th width="400">영화명</th>
				<th width="150">개봉일</th>
				<th width="100">누적관객수</th>
			</tr>
			<%-- 영화 정보 파싱 결과가 출력될 위치 --%>
		</table>
	</div>
	<hr>
	<div id="resultArea2"></div>
</body>
</html>











