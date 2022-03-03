package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.SampleVO;
import util.DbUtil;

public class sampleDAO extends DbUtil {
	
	public void create(SampleVO vo) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n INSERT INTO sample ");
		sql.append("\n (num, strData, sampleDate() ");
		sql.append("\n Values (null, ?, curdate()) ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
				
		try {
			conn = dbCoon();
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, vo.getStrData());
			
			int res = stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public List<SampleVO> read() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<SampleVO> list = new ArrayList<SampleVO>();
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n SELECT * FROM sample ");
		
		try {
			conn = dbCoon();
			
			stmt = conn.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				list.add(
				new SampleVO(
				rs.getInt("num"),
				rs.getString("strData"),
				rs.getDate("sampleDate")));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	
		return list;
	}
	
	public SampleVO read(SampleVO vo) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		SampleVO sample = null;
		
		
		StringBuffer sql = new StringBuffer();
		sql.append("\n SELECT * FROM sample ");
		
		try {
			conn = dbCoon();
			
			stmt = conn.prepareStatement(sql.toString());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				sample = new SampleVO(
				rs.getInt("num"),
				rs.getString("strData"),
				rs.getDate("sampleDate"));
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		} 
		return sample;
	}
	
	public void update(SampleVO vo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n UPDATE sample ");
		sql.append("\n Set StrData = ?, SampleDate = ? ");
		sql.append("\n WHERE num = ? ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		int idx = 1;
				
		try {
			conn = dbCoon();
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(idx++, vo.getStrData());
			stmt.setDate(idx++, (Date) vo.getSampleDate());
			stmt.setInt(idx++, vo.getNum());
			
			int res = stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
	public void delete(SampleVO vo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n DELETE * FROM sample ");
		
		Connection conn = null;
		PreparedStatement stmt = null;
				
		try {
			conn = dbCoon();
			
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, vo.getNum());
			
			int res = stmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			dbClose(conn, stmt, null);
		}
	}
	
}
