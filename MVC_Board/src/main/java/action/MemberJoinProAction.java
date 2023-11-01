package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// FrontController 클래스와 연동하여 컨트롤러 역할을 수행할 Action 클래스 정의
// => 공통된 메서드 execute() 를 직접 정의하지 않고
// Action 인터페이스를 상속받아 추상메서드 execute() 를 오버라이딩(구현)
public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberJoinProAction");
		
		// 포워딩 정보를 저장할 ActionForward 타입 변수 선언
		ActionForward forward = null;
		
		
		
		// 포워딩 정보다 저장된 ActionForward 객체 리턴
		return forward;
	}

}
