package jsp08_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2Main") // http://localhost:8080/StudyJSP/Servlet2Main
public class Servlet2Main extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet2Main");
		
		// "jsp08_servlet/servlet2_main.jsp" 페이지로 포워딩
		// => 기존 요청 주소(=서블릿 주소) 유지를 위해 Dispatch 방식 포워딩
		// => 현재 요청 주소 : http://localhost:8080/StudyJSP/Servlet2Main
		// => 컨텍스트 루트(StudyJSP)에 해당하는 JSP 디렉토리가 webapp 이므로
		//    하위 디렉토리 구조까지 명시해야함
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp08_servlet//servlet2_main.jsp");
		dispatcher.forward(request, response);
	}

}
