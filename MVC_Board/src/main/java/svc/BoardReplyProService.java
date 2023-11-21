package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardReplyProService {

	// 답글 작성 요청을 위한 registReplyBoard() 메서드 정의
	// dao의 db 작업을 제외하고는 글쓰기와 동일한 작업이다.
	public boolean registReplyBoard(BoardBean board) {
		System.out.println("BoardReplyProService - registReplyBoard()");
		
		boolean isWriteSuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO - insertReplyBoard() 메서드 호출하여 글쓰기 작업 요청
		// => 파라미터 : BoardBean 객체   리턴타입 : int(insertCount)
		int insertCount = dao.insertReplyBoard(board);
		
		// 작업 처리 결과에 따른 트랜잭션 처리
		if(insertCount > 0) {
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);

		return isWriteSuccess;
	}

}
