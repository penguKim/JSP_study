package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import db.JdbcUtil;
import vo.MemberBean;

//실제 비즈니스 로직을 수행하는 MemberDAO 클래스 정의
//=> 각 Service 클래스 인스턴스에서 MemberDAO 인스턴스에 접근 시 고유 데이터가 불필요하므로
// MemberDAO 인스턴스는 애플리케이션에서 단 하나만 생성하여 공유해도 된다!
// 따라서, 싱글톤 디자인 패턴을 적용하여 클래스를 정의하면
// 하나의 인스턴스를 모두가 공유하므로 메모리 낭비를 최소화 할 수 있다!
public class MemberDAO {
	// --------- 싱글톤 디자인 패턴을 활용한 MemberDAO 인스턴스 생성 작업 ----------
	// 1. 외부에서 인스턴스 생성이 불가능하도록 생성자를 private 접근제한자로 선언
	private MemberDAO() {} // 외부에서 생성자 호출이 불가능하므로 인스턴스 생성 불가
	
	// 2. 자신의 클래스 내에서 직접 인스턴스 생성하여 멤버변수에 저장
	//    => 멤버변수는 외부에서 접근이 불가능하도록 private 접근제한자로 선언
	//    => 인스턴스 생성 없이도 클래스가 메모리에 로딩될 때 함께 로딩되어
	//       클래스명만으로 접근 가능하도록 static 멤버변수로 선언
	//    => static 메서드에서 접근 가능하기 위해서도 static 멤버변수로 선언해야함
	private static MemberDAO instance = new MemberDAO();
	
	// 3. 생성된 인스턴스를 외부로 리턴하는 Getter 메서드 정의
	//    => 누구나 접근 가능하도록 public 접근제한자로 선언
	//    => 인스턴스 생성 없이도 클래스가 메모리에 로딩될 때 함께 로딩되어
	//       클래스명만으로 접근 가능하도록 static 메서드로 선언
	//       (주의! 메서드 내에서 접근할 변수도 반드시 static 메서드로 선언되어야 한다!)
	public static MemberDAO getInstance() {
		return instance;
	}
	// -------------------------------------------------------------------
	// DB 접근에 사용될 Connection 객체를 Service 로부터 전달받기 위한
	// Connection 타입 멤버변수 선언 및 Setter 메서드 정의
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	// -------------------------------------------------------------------
	// 회원 가입 작업 수행 - INSERT
	// => 파라미터 : MemberBean 객체   리턴타입 : int(insertCount)
	public int insertMember(MemberBean member) {
		System.out.println("MemberDAO - insertMember()");
		int insertCount = 0;
		
		// 주의! Connection 객체는 이미 외부(Service)로부터 전달받은 상태이므로
		// 다시 JdbcUtil.getConnection() 메서드를 호출하지 않도록 해야한다! (서로 다른 객체)
		
		// DB 작업에 필요한 변수 선언
		PreparedStatement pstmt = null;
		
		try {
			// 3단계. SQL 구문 작성 및 전달
			// member 테이블에 모든 데이터 추가 - INSERT
			// => 번호(idx) 컬럼은 자동 증가(AUTO_INCREMENT) 컬럼이므로 null 값 전달
			// => 등록일(reg_date) 컬럼은 DB 서버의 현재 날짜 및 시각 활용(now() 함수 호출)
			String sql = "INSERT INTO member VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
			// PreparedStatement 객체의 setXXX() 메서드 호출하여 파라미터(?) 데이터 교체
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getJumin());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getJob());
			pstmt.setString(8, member.getGender());
			pstmt.setString(9, member.getHobby());
			pstmt.setString(10, member.getMotivation());
			// 4단계. SQL 구문 실행 및 결과 처리
			// => INSERT 구문이므로 PreparedStatement 객체의 executeUpdate() 메서드 호출
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// 3단계 or 4단계에서 SQLException 예외 발생 시 실행될 코드 기술
			System.out.println("INSERT 구문 오류 발생! - insertMember()");
			e.printStackTrace();
		} finally {
			// 예외 발생 여부와 관계없이 항상 실행될 코드 기술
			// DB 자원 반환
			// => 주의! Connection 객체는 Service 에서 반환하므로 DAO 에서 반환 금지!
			JdbcUtil.close(pstmt);
		}
		// INSERT 작업 결과 리턴
		return insertCount; // MemberJoinProService 로 리턴
	}
	
	
}
