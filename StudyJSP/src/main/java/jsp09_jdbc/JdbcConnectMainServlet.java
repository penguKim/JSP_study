package jsp09_jdbc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/StudyJSP/JdbcConnectMain 매핑 시
@WebServlet("/JdbcConnectMain")
//http://localhost:8080/StudyJSP/jsp09_jdbc/JdbcConnectMain 매핑 시
//@WebServlet("/jsp09_jdbc/JdbcConnectMain")
public class JdbcConnectMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnectMainServlet 호출!");
		
		// "webapp/jsp09_jdbc 디렉토리 내의 jdbc_main.jsp" 페이지로 포워딩
		// ---------------------------------------------------------------
		// 1) 리다이렉트
		//    => 현재 매핑된 URL : http://localhost:8080/StudyJSP/JdbcConnectMain
		//    => /StudyJSP = webapp 디렉토리이므로 서브디렉토리(jsp09_jdbc) 명시 필요
//		response.sendRedirect("jsp09_jdbc/jdbc_main.jsp");
		// 주소표시줄 : http://localhost:8080/StudyJSP/jsp09_jdbc/jdbc_main.jsp
		// => 새로운 요청 주소로 변경됨
		
		// 만약, 매핑 URL 이 "/jsp09_jdbc/JdbcConnectMain" 일 때
		// 서브디렉토리 구조가 URL 에 포함되어 있으므로 jdbc_main.jsp 파일명만 명시
//		response.sendRedirect("jdbc_main.jsp");
		
		// ---------------------------------------------------------------
		// 2) 디스패치
		//    => 현재 매핑된 URL : http://localhost:8080/StudyJSP/JdbcConnectMain
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp09_jdbc/jdbc_main.jsp");
		dispatcher.forward(request, response);
		// 주소표시줄 : http://localhost:8080/StudyJSP/JdbcConnectMain
		// => 이전 요청 주소가 유지됨
	}

}
