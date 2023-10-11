<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>영역 객체 속성 및 범위</h1>
	<%
	
	// 각 영역 객체에 속성값 저장하기
	pageContext.setAttribute("pageScope", "pageContext value");
	request.setAttribute("requestScope", "request value");
	session.setAttribute("sessionScope", "session value");
	application.setAttribute("applicationScope", "application value");
	%>
	
	<%-- 각 영역 객체에 저장된 속성값을 현재 페이지에서 확인하기 - getAttribute() --%>
	<h3>pageContext 객체 값 : <%=pageContext.getAttribute("pageScope") %></h3>
	<h3>request 객체 값 : <%=request.getAttribute("requestScope") %></h3>
	<h3>session 객체 값 : <%=session.getAttribute("sessionScope") %></h3>
	<h3>application 객체 값 : <%=application.getAttribute("applicationScope") %></h3>
	<%-- 속성 저장 페이지에서는 모든 영역 객체의 속성값 확인 가능함 --%>
	
	<%
	// attributeScopeTest2.jsp 페이지로 이동
	// 1. Redirect(리다이렉트) 방식 : response 객체의 sendRedirect() 메서드 사용
	// => 기존 요청에 다른 새로운 요청이 발생하여 기존 request 객체가 제거되고
	//    새로운 request 객체가 생성되므로, 기존 request 객체에 저장된 정보는 제거됨
	//    따라서, 리다이렉트 된 페이지에서 기존 request 객체의 속성에 접근 시 null 값 출력됨
	//    또한, 새로운 요청 주소로 웹브라우저 주소표시줄의 주소(URL)가 변경됨
// 	response.sendRedirect("attributeScopeTest2.jsp");
	
	// pageContext 객체의 속성값은 현재 페이지를 벗어났으므로 null 값이 출력됨
	// request 객체의 속성값은 새로운 요청이 발생했으므로 null 값이 출력됨
	// session 객체의 속성값은 세션이 유지되므로 저장된 속성값이 유지(출력)됨
	// application 객체의 속성값은 서버가 동작중이므로 저장된 속성값이 유지(출력)됨
	// ------------------------------------------------------------------------------------------
	// 2. Dispatch(디스패치) 방식(= 포워딩) : pageContext 객체의 forward() 메서드 사용
	pageContext.forward("attributeScopeTest2.jsp");
	// => 기존 요청이 유지된 채로 서버측에서 페이지 이동을 처리한 후 응답을 수행하므로
	//    하나의 요청/응답으로 처리되어 기존 request 객체가 그대로 유지됨(새로 생성 X)
	//    따라서, 디스패치 방식으로 포워딩 된 페이지에서 기존 request 객체의 속성에 접근 가능
	//    또한, 새로운 요청이 아니므로 브라우저 주소표시줄의 주소(URL)가 그대로 유지됨
	
	// pageContext 객체의 속성값은 현재 페이지를 벗어났으므로 null 값이 출력됨
	// request 객체의 속성값은 이전 요청이 그대로 유지되므로 저장된 속성값이 유지(출력)됨
	// session 객체의 속성값은 세션이 유지되므로 저장된 속성값이 유지(출력)됨
	// application 객체의 속성값은 서버가 동작중이므로 저장된 속성값이 유지(출력)됨
	%>
</body>
</html>