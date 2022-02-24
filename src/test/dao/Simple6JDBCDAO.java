package test.dao;
/**
 * DB에 등록해보자~~~~~! 
 */

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class Simple6JDBCDAO {

	public static void main(String[] args) {
		String paramVarchar = "varcharTest";
		String paramChar = "charTest";
		double paramInt = 200.001;
		Date paramDate = new Date(System.currentTimeMillis());
		Timestamp paramDateTime = new Timestamp(System.currentTimeMillis());
		
		
		String url = "jdbc:mysql://localhost:3306/smart?characterEndoing=UTF-8&serverTimezone=Asia/Seoul";
		String user = "root";
		String password = "smart";
		String sql = "INSERT INTO exam VALUES (?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
//			1. 드라이버 로드 (Class.forName())
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2. DB연결(DriverManager.getConnection())
			conn = DriverManager.getConnection(url, user, password);
//			3. SQL문작성(Statement, PrepareStatement)
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, paramVarchar);
			stmt.setString(2, paramChar);
			stmt.setDouble(3, paramInt);
			stmt.setDate(4, paramDate);
			stmt.setTimestamp(5, paramDateTime);
			//숫자가 겹치면 안된다. 
			
//			4. SQL문실행(executeQuery(), executeUpdate())
			int res = stmt.executeUpdate(); // Query 실행.
//			5. Select문 만 ResultSet 객체를 반환한다. insert,update,delete 는 executeUpdate 사용.
//			   나머진 int를 반환한다.
			if(res> 0 ) {
				System.out.println(res+"개의 행이 추가되었습니다.");
			} else {
				System.out.println("등록실패했습니다.");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
//			6. 닫기(close())
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
