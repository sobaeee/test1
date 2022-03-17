package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.MemberVO;

public class MemberDAO {
	private String url = "jdbc:mysql://localhost:3306/kblab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String password = "smart";

	/**
	 * 트랜잭션 처리
	 * 
	 * @param mvo
	 */

	public void create(MemberVO mvo) {
		String sql = " INSERT INTO member (id, pw, uname, regdate) VALUES (?, ?, ?, now()) ";
		String sql2 = " INSERT INTO login (id, pw) VALUES (?, ?) ";

		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false); //false가 되어있어야 한다.
			
			//member 가입
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, mvo.getId());
			stmt.setString(2, mvo.getPw());
			stmt.setString(3, mvo.getUname());

			stmt.executeUpdate();
			
			//login 등록
			stmt2 = conn.prepareStatement(sql2);
			stmt2.setString(1, mvo.getId());
			stmt2.setString(2, mvo.getPw());
			
			stmt2.executeUpdate();
			
			
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (stmt != null) stmt.close();
				if (stmt2 != null) stmt2.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
