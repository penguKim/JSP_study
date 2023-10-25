package jsp11_jdbc_dao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DaoUpdate")
public class DaoUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DaoUpdateServlet");
		
		StudentDAO dao = new StudentDAO();
		
		int updateCount = dao.update();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("DaoSelect");
		dispatcher.forward(request, response);
	}

}
