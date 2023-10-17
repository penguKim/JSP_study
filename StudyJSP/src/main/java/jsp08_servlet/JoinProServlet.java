package jsp08_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/jsp08_servlet/JoinPro")
public class JoinProServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		// 취미는 동일한 name 속성으로 복수개의 항목이 전달되므로 String[] 타입 사용
		String[] arrHobby = request.getParameterValues("hobby");
		String motivation = request.getParameter("motivation");
		
		System.out.println("이름 : " + name);
		System.out.println("아이디 : " + id);
		System.out.println("패스워드 : " + passwd);
		System.out.println("주민번호 : " + jumin);
		System.out.println("이메일 : " + email);
		System.out.println("직업 : " + job);
		System.out.println("성별 : " + gender);
		System.out.println("가입동기 : " + motivation);
		// java.util.Arrays 클래스의 toString() 메서드를 호출하여 배열 -> 문자열 변환 가능
		// 또는 반복문 사용하여 배열 내의 데이터 차례대로 접근 후 출력도 가능
//		System.out.println("취미 : " + Arrays.toString(arrHobby));
		System.out.print("취미 : ");
		for(String hobby : arrHobby) {
			System.out.print(hobby + " ");
		}
		
		
		PrintWriter out = response.getWriter();
		
//		response.setContentType("text/html; charset=UTF-8");
//		out.print("<script>");
//		out.print("alert('회원 가입을 축하합니다!.');");
//		out.print("history.back();");
//		out.print("</script>");
		
		
		
		// 메인페이지(servlet1_main.jsp)
//		response.sendRedirect("servlet1_main.jsp");
		// 주의! 리다이렉트 시 자바스크립트를 동시에 사용 불가!
		// => 클라이언트로 응답 정보를 전송은 하지만 리다이렉트 정보가 전송되므로
		//    일반적인 HTML 요소 및 자바스크립트는 클라이언트에서 실행되지 못한다.
		// => 따라서, 자바스크립트를 활용하여 메세지 출력 및 페이지 이동 처리 시
		//    자바스크립트를 사용한 페이지 이동 처리 필수!(location.href)
		
		// 디스패치 포워딩 방식은 서버에서 처리하고 결과를 클라이언트에게 응답해주기에
		// 동일한 이유로 HTML 요소 및 자바스크립트는 실행되지 못한다.
	response.setContentType("text/html; charset=UTF-8");
	out.print("<script>");
	out.print("alert('회원 가입을 축하합니다!.');");
	out.print("location.href='servlet1_main.jsp';");
	out.print("</script>");
	
	}

}
