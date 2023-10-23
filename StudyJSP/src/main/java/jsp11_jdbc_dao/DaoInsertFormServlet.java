package jsp11_jdbc_dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DaoInsertForm")
public class DaoInsertFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DaoInsertFormServlet");
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp11_jdbc_dao/insert_Form.jsp");
		dispatcher.forward(request, response);
				
	}

}
