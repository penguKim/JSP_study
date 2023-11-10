package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

public class MemberModifyProService {

	public boolean modifyMember(MemberBean member) {
		System.out.println("MemberModifyProService - modifyMember()");
		boolean isModifySuccess = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);

		// MemberDAO - updateMember() 메서드 호출하여 회원 정보 수정 요청
		// => 파라미터 : MemberBean 객체   리턴타입 : int(updateCount)
		int updateCount = dao.updateMember(member);
		if(updateCount > 0) {
			JdbcUtil.commit(con);
			isModifySuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		JdbcUtil.close(con);
		
		return isModifySuccess;
	}

}
