package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController");
		
		// 공통변수 선언
		Action action = null;
		ActionForward forward = null;
		
		// 서블릿 주소 추출하기
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// URL 매핑
		if(command.equals("/BoardWriteForm.bo")) {
			System.out.println("글쓰기 폼");
			// 뷰페이지로 바로 이동
			forward = new ActionForward();
			forward.setPath("board/board_write_form.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/BoardWritePro.bo")) {
			System.out.println("글쓰기");
			// 비즈니스 로직 처리
			action = new BoardWriteProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardList.bo")) {
			System.out.println("글목록");
			action = new BoardListAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardDetail.bo")) {
			System.out.println("게시글조회");
			// 비즈니스 로직 처리
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardDelete.bo")) {
			System.out.println("게시글삭제");
			// 비즈니스 로직 처리
			action = new BoardDeleteAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardModifyForm.bo")) {
			// 비즈니스 로직 처리
			action = new BoardModifyFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardModifyPro.bo")) {
			System.out.println("게시글수정");
			// 비즈니스 로직 처리
			action = new BoardModifyProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardReplyForm.bo")) {
			// 비즈니스 로직 처리
			action = new BoardReplyFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardReplyPro.bo")) {
			System.out.println("답글달기");
			// 비즈니스 로직 처리
			action = new BoardReplyProAction();
			forward = action.execute(request, response);
		}
		
		
		
		
		
		
		if(forward != null) {
			if(forward.isRedirect()) { // 리다이렉트 방식
				response.sendRedirect(forward.getPath());
			} else { // 디스패치 방식
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
}
