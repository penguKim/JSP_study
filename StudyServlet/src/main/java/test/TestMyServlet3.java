package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/StudyServlet/myServlet3 주소 요청 시
//서블릿 주소("/myServlet3") 주소를 매핑할 TestMyServlet3 클래스 정의
//=> web.xml 파일을 통한 매핑 대신 @WebServlet 어노테이션을 사용하여 매핑 설정
//=> 서블릿 클래스 상단에 @WebServlet("/서블릿주소") 형식으로 설정

@WebServlet("/myServlet3")
public class TestMyServlet3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestMyServlet3 - doGet() 메서드 호출됨!");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("TestMyServlet3 - doPost() 메서드 호출됨!");
	}
}
