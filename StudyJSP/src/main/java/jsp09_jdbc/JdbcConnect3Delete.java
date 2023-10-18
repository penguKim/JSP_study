package jsp09_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JdbcConnect3_DELETE")
public class JdbcConnect3Delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3Delete");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/study_jsp5";
			String user = "root";
			String pass = "1234";
			// JDBC 드라이버 로드
			Class.forName(driver);
			System.out.println("드라이버 로드 성공!");
			// DB 연결
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 성공!");
			// SQL 구문 작성 및 전달
			String sql = "DELETE FROM jsp09_student";
			pstmt = con.prepareStatement(sql);
			System.out.println(pstmt);
			// SQL 구문 실행
			int deleteCount = pstmt.executeUpdate();
			System.out.println("회원 삭제(DELETE) 성공 - " + deleteCount);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("DB 연결 실패! 및 SQL 구문 오류 발생!");
			e.printStackTrace();
			
		} finally {
			try {
				// 종료를 위한 자원 반납
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
