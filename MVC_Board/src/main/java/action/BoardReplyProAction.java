package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.BoardReplyProService;
import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardReplyProAction");
		
		ActionForward forward = null;
		
		// 세션 아이디 존재하지 않을 경우 처리
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("sId");
		
		// 자바스크립트 사용하여 "잘못된 접근입니다!" 출력 후 메인페이지로 이동
		if(id == null) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 접근입니다!');");
				out.println("location.href = './';");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		// 폼 파라미터 데이터 가져오기
		// => 세션아이디는 board_name 에 저장
		BoardBean board = new BoardBean();
		board.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		board.setBoard_name(id);
		// 답글 작성에 필요한 추가 정보(참조글번호, 들여쓰기레벨, 순서번호)도 저장
		board.setBoard_re_ref(Integer.parseInt(request.getParameter("board_re_ref")));
		board.setBoard_re_lev(Integer.parseInt(request.getParameter("board_re_lev")));
		board.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		board.setWriter_ip(request.getRemoteAddr()); // 작성자 IP 주소
//		System.out.println(board);
		
		// BoardReplyProService - registReplyBoard() 메서드 호출하여 글쓰기 작업 요청
		// => 파라미터 : BoardBean 객체   리턴타입 : boolean(isWriteSuccess)
		BoardReplyProService service = new BoardReplyProService();
		boolean isWriteSuccess = service.registReplyBoard(board);
			
		// 글쓰기 작업 요청 처리 결과 판별 - 리턴값(isWriteSuccess) 활용
		// => 실패 시 자바스크립트를 사용하여 "글쓰기 실패!" 출력 및 이전페이지로 돌아가기
		// => 성공 시 글목록 표시를 위해 BoardList.bo 서블릿 주소를 Redirect 방식으로 설정
		if(!isWriteSuccess) {
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('글쓰기 실패!);");
				out.println("history.back();");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// 페이지번호 없을 경우 기본값 처리
			String pageNum = request.getParameter("pageNum");
			// 만약, 페이지번호가 null 또는 널스트링 일 경우 기본값 "1" 설정
			if(pageNum == null || pageNum.equals("")) {
				pageNum = "1";
			}
			
			forward = new ActionForward();
			forward.setPath("BoardList.bo?pageNum=" + pageNum); // 글목록 이동 시 페이지번호 전달
			forward.setRedirect(true);
		}
		
		
		return forward;
	}

}
