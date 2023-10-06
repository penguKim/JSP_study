<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String passwd2 = request.getParameter("passwd2");
	// 주민번호 앞, 뒷자리를 하나의 변수에 결합 => DB 등에 저장 시 필요
	String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
	String address = request.getParameter("postCode") + "<br>" + 
		request.getParameter("address1") + "<br>" + request.getParameter("address2");
	// 이메일 계정명, 도메인을 하나의 변수에 결합 => DB 등에 저장 시 필요
	String email = request.getParameter("email1") + "@" + request.getParameter("email2");
	String job = request.getParameter("job");
	String gender = request.getParameter("gender");
	String[] hobbys = request.getParameterValues("hobby");
	String motivation = request.getParameter("motivation");
	
	
	%>
	<h1>request3Pro.jsp - 회원가입 데이터</h1>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>아이디</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=passwd %></td>
		</tr>
		<tr>
			<th>비밀번호 확인</th>
			<td><%=passwd2 %></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><%=jumin %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=address %></td>
		</tr>
		<tr>
			<th>E-mail</th>
			<td><%=email %></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><%=job %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=gender %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<% 
// 				for(int i = 0; hobbys.length; i++) {
// 					out.print(hobbys[i] + " ");
// 				}
				
				for(String hobby : hobbys) {
					out.print(hobby + " ");
				}
				%>
			</td>
		</tr>
		<tr>
			<th>가입동기</th>
			<td><%=motivation %></td>
		</tr>
	</table>
</body>
</html>