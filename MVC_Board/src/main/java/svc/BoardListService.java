package svc;

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardListService {
	
	// 글목록 조회 요청
	// => 파라미터 : 없음   리턴타입 : java.util.List<BoardBean>(boardList)
	public List<BoardBean> getBoardList() {
		System.out.println("BoardListService - getBoardList()");
		List<BoardBean> boardList = null;
		
		Connection con = JdbcUtil.getConnection();
		BoardDAO dao = BoardDAO.getInstance();
		dao.setConnection(con);
		
		// BoardDAO - selectBoardList() 메서드 호출하여 글목록 조회 작업 요청
		// => 파라미터 : 없음   리턴타입 : java.util.List<BoardBean>(boardList)
		boardList = dao.selectBoardList();
		
		JdbcUtil.close(con);
		
		return boardList;
	}

}
