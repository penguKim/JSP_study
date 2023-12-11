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
		let key = "f5eef3421c602c6cb7ea224104795888";
		let movieCd = ${param.movieCd };
		console.log(key);
		console.log(movieCd);

		$.ajax({
			type: "GET", // 생략 가능
			url: "https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
			data: {
				key: key,
				movieCd: movieCd
			},
			dataType: "json", // 응답 데이터를 JSON 객체로 취급 
			success: function(data) {
				let movieInfoResult = data.movieInfoResult;
				let movieInfo = movieInfoResult.movieInfo;
				let genres = "";
				let actors = "";
				for(let genre of movieInfo.genres) {
					genres += genre.genreNm + "/";
				}
				if(movieInfo.actors[0] != null) {
					for(let i = 0; i < movieInfo.actors.length; i++) {
						actors += movieInfo.actors[i].peopleNm + "/"
					}
				} else {
					actors = "";
				}
				
// 				alert(movieInfo.movieNm);
				$("table").append("<tr>"
									+ "<td>" + movieInfo.movieNm + "</td>"
									+ "<td>" + movieInfo.showTm + "</td>"
									+ "<td>" + movieInfo.prdtYear + "</td>"
									+ "<td>" + movieInfo.openDt + "</td>"
									+ "<td>" + movieInfo.nations[0].nationNm + "</td>"
									+ "<td>" + genres + "</td>"
									+ "<td>" + movieInfo.directors[0].peopleNm + "</td>"
									+ "<td>" + actors + "</td>"
									+ "<td>" + movieInfo.audits[0].watchGradeNm + "</td>"
									+ "</tr>"					
				);
			}
		});
		
	});

</script>
</head>
<body>
	<div id="resultArea">
		<table border="1">
			<tr>
				<th>제목</th>
				<th>상영시간</th>
				<th>제작년도</th>
				<th>개봉일</th>
				<th>제작국가</th>
				<th>장르</th>
				<th>감독</th>
				<th>배우</th>
				<th>관람등급</th>
			</tr>
		</table>
	</div>
</body>
</html>