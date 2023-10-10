<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="right">
	<h4>
		<a href="sessionTest3_main.jsp">HOME</a> |
		<%--
		로그인 성공/실패에 따른 작업 수행(= 서로 다른 하이퍼링크 표시)
		- 세션 아이디(sId 속성값)가 없을 경우
		
		- 세션 아이디(sId 속성값)가 있을 경우
		
		 --%>
		<a href="sessionTest3_loginForm.jsp">로그인</a> |
		<a href="sessionTest3_joinForm.jsp">회원가입</a>
	</h4>
</div>
