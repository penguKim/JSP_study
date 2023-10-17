package jsp08_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletMain") // http://localhost:8080/StudyJSP/ServletMain
public class MainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("MainServlet");
		
		// "jsp08_servlet/servlet1_main.jsp" 페이지 포워딩
		// ----------------------------------------------------------
		// [ Dispatch vs Redirect 방식 ]
		// 1) Redirect 방식
		// => response 객체의 sendRedirect() 메서드 활용
		// => 처음 요청 주소가 아닌 새 요청 주소(URL)로 변경됨
		
		// 만약, 요청 주소(URL)가 http://localhost:8080/StudyJSP/ServletMain 일 경우
		// 컨텍스트 루트(StudyJSP)가 webapp 디렉토리를 가리키므로 현재 경로는 webapp 디렉토리이다.
		// 따라서, 대상 파일 지정 시 디렉토리 구조 지정 생략 후 파일명만 지정 시
		// 해당 파일이 webapp 디렉토리에 위치한 것으로 간주함
//		response.sendRedirect("servlet1_main.jsp"); // webapp/servlet1_main.jsp 가리킴
		// => 해당 경로 상에 파일이 존재하지 않으므로 404 오류 발생
		
		// 결국, 현재 경로(webapp)의 서브디렉토리(jsp08_servlet)에 대상 파일이 존재하므로
		// 서브디렉토리명까지 모두 명시해야한다!
		response.sendRedirect("jsp08_servlet/servlet1_main.jsp");
		// => http://localhost:8080/StudyJSP/jsp08_servlet/servlet1_main.jsp
		// ---------------------------------------------------------------------------------
		// 만약, 요청 주소(URL)가 http://localhost:8080/StudyJSP/jsp08_servlet/ServletMain 일 경우
//		response.sendRedirect("servlet1_main.jsp");
		// => 현재 위치가 StudyJSP/jsp08_servlet 이므로 webapp/jsp08_servlet 과 같다.
		//    따라서, 대상 파일명만 지정하면 해당 디렉토리까지 접근함
		
		// =================================================================================
		// 2) Dispatch 방식
		// => request 객체의 getRequestDispatcher() 메서드를 호출하여
		//    RequestDispatcher 객체를 리턴받아 forward() 메서드로 포워딩
		//    (파라미터 : 포워딩 할 경로)
//		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp08_servlet/servlet1_main.jsp");
//		dispatcher.forward(request, response);
		// => http://localhost:8080/StudyJSP/ServletMain
		//    (서블릿 주소에 디렉토리 구조 없으므로 파일 지정 시 디렉토리 구조까지 명시 필요함)
		// => 처음 요청 주소(URL)가 그대로 유지됨
		
	}

}





 



