package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardListAction");
		ActionForward forward = null;
		
		// 비회원도 목록 조회가 가능하므로 세션 아이디 체크 생략
		// -----------------------------------------------------
		// BoardListService - getBoardList() 메서드 호출하여 글목록 조회 요청
		// => 파라미터 : 없음   리턴타입 : java.util.List<BoardBean>(boardList)
		BoardListService service = new BoardListService();
		List<BoardBean> boardList = service.getBoardList();
		System.out.println(boardList);

		// 11/8일 => List 객체 뷰페이지로 전송 필요
		
		// ActionForward 객체를 사용하여 "board/board_list.jsp" 포워딩 정보 설정
		forward = new ActionForward();
		forward.setPath("board/board_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
