package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// FrontController 클래스와 연동하여 컨트롤러 역할을 수행할 Action 클래스 정의
// => FrontController 의 지시를 통해 비즈니스 로직 처리를 위한 준비 및 포워딩 설정 작업 수행
public class MemberJoinProAction_Backup {
	// MemberFrontController 로부터 호출받아
	// 회원가입 비즈니스 로직을 수행할 execute() 메서드 정의
	// => 컨트롤러 역할을 수행하므로 FrontController 와 마찬가지로 request, response 객체 필요
	//    파라미터 : HttpServletRequest(request), HttpServletResponse(response)
	// => 리턴타입 : vo.ActionForward
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		// 비즈니스 로직 수행 완료 후 메인 페이지로 리다이렉트(URL 주소 유지 불필요)
		forward = new ActionForward();
		forward.setPath("./");
		forward.setRedirect(true);
		
		// 포워딩 정보가 담긴 ActionForward 객체 리턴
		return forward;
	}
}
