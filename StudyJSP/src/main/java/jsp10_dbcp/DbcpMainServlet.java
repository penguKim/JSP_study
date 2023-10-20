package jsp10_dbcp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/StudyJSP/JdbcConnectMain 매핑 시
@WebServlet("/DbcpMain")
//http://localhost:8080/StudyJSP/jsp09_jdbc/JdbcConnectMain 매핑 시
//@WebServlet("/jsp09_jdbc/JdbcConnectMain")
public class DbcpMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DbcpMainServlet 호출!");
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp10_dbcp/dbcp_main.jsp");
		dispatcher.forward(request, response);

	}

}
