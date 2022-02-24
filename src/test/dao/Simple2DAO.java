package test.dao;

//import java.sql.Connection; =>  의미가 없다(삭제하기).
import java.sql.*;
import java.util.List;

public class Simple2DAO {

	/**
	 * C : create() 등록하는 메소드 public : 접근지정자 param : 등록될 값 return : 없음.
	 */

	public void create() {
		// 코드 작성
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append("\n INSERT INTO exam ");
		sql.append("\n (varcharTest, charTest, doubleTest, dateTest, dateTimeTest) ");
		sql.append("\n VALUES ('가변폭문자열', '고정폭문자열', 1.1, curdate(), now()) ");

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver"); // 패키지명.클래스명(클래스는 대문자 패키지는 소문자)
			// DB연결
			conn = DriverManager.getConnection(url, user, password);
			// prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			// prepareStatement로 리턴값을 받는다. 메소드를 객체로 만들어서 객체.메소드로 실행을 시킨다.
			int res = stmt.executeUpdate(); // <이것이 있어야 실행이 된다.
			// 결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			// ClassNotFoundException -> Exception으로 수정
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		// 닫기
	}

	/**
	 * R : read() 조회하는 메소드 public : 접근지정자 param : 조회할 값 return : List
	 */

	public List read() {
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT * FROM exam ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		// 코드 작성
		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB연결
			conn = DriverManager.getConnection(url, user, password);
			// prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery(); // executeQuery가 ResultSet을 리턴해서 ResultSet으로 받음
			// 결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();

			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		// 닫기
		return null;
	}

	/**
	 * U : update() 수정하는 메소드 public : 접근지정자 param : 수정될 값 return : 없음
	 */

	public void update() {
		String url= "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user= "root";
		String password= "smart";
		StringBuffer sql = new StringBuffer();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 코드 작성
		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB연결
			conn = DriverManager.getConnection(url, user, password);
			// prepareStatement(SQL작성 실행)
			stmt = conn.prepareStatement(sql.toString());
			int res = stmt.executeUpdate();
			// 결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}

		}
		// 닫기
	}

	/**
	 * D : delete() 삭제하는 메소드 public : 접근지정자 param : 삭제될 키값 return : 없음
	 */

	public void delete() {
		String url = "jdbc:mysql://localhost:3306/smart?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		StringBuffer sql = new StringBuffer();
		sql.append(" DELETE FROM exam ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// 코드 작성
		try {
			// 드라이버로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB연결
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql.toString());
			int res = stmt.executeUpdate();
			// prepareStatement(SQL작성 실행)
			// 결과처리(Select문만 ResultSet 객체 리턴)
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		// 닫기.
	}
}
