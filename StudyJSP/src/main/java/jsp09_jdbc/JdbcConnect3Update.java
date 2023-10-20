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

@WebServlet("/JdbcConnect3_UPDATE")
public class JdbcConnect3Update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JdbcConnect3Update");

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
			// 번호가 2 인 레코드의 이름을 '강감찬'으로 변경
			int idx = 2;
			String name = "강감찬";
			String sql = "UPDATE jsp09_student SET name = ? WHERE idx = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, idx);
			System.out.println(pstmt);
			// SQL 구문 출력
			int updateCount = pstmt.executeUpdate();
			System.out.println("회원 갱신(UPDATE) 성공 - " + updateCount);
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println("DB 연결 실패! 또는 SQL 구문 오류 발생!");
			e.printStackTrace();
			
		} finally {
			try {
				
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
