package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.BoardDTO;
import domain.BoardVO;

public class BoardDAO {

	private String url = "jdbc:mysql://localhost:3306/kblab?characterEncoding=UTF-8&serverTimezone=Asia/Seoul";
	private String user = "root";
	private String password = "smart";

	public void create(BoardVO vo) {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO board(board_id, writer, title, content, regdate, hit) ");
		query.append(" VALUES (null, ?, ?, ?, now(), 0) ");
		String sql = query.toString();

		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, vo.getWriter());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}
	}

	public List<BoardVO> read() {

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO bvo = null;

		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, m.uname, b.regdate, b.hit ");
		query.append(" FROM board as b JOIN member as m ");
		query.append(" ON b.writer = m.id ");
		query.append(" ORDER BY b.board_id DESC ");
		String sql = query.toString();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVO();
				bvo.setBoard_id(rs.getInt("board_id"));
				bvo.setTitle(rs.getString("title"));
				// list.add 괄호에 모두를 넣으려면 이 사이에 content 대신 null 값을 넣어 자리를 채워준다. 채워주지 않으면 공백이 남아
				// 실행이 안됨.
				bvo.setWriter(rs.getString("uname"));
				bvo.setRegdate(rs.getTimestamp("regdate"));
				bvo.setHit(rs.getInt("hit"));
				list.add(bvo);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return list;
	}

	public List<BoardVO> read(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<BoardVO> list = new ArrayList<BoardVO>();

		BoardVO bvo = null;

		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, m.uname as writer, b.regdate, b.hit ");
		query.append(" FROM board as b JOIN member as m ");
		query.append(" ON b.writer = m.id ");

		if ("title".equals(dto.getSfl())) {
			query.append(" WHERE b.title LIKE ? ");
		}

		if ("content".equals(dto.getSfl())) {
			query.append(" WHERE b.content LIKE ? ");
		}

		if ("title|content".equals(dto.getSfl())) {
			query.append(" WHERE b.title LIKE ? OR b.content LIKE ? ");
		}

		query.append(" ORDER BY b.board_id DESC ");
		String sql = query.toString();
		System.out.println(query);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);

			if ("title".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeyword() + "%");
			}

			if ("content".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeyword() + "%");
			}

			if ("title|content".equals(dto.getSfl())) {
				stmt.setString(1, "%" + dto.getKeyword() + "%");
				stmt.setString(2, "%" + dto.getKeyword() + "%");
			}

			rs = stmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVO();
				bvo.setBoard_id(rs.getInt("board_id"));
				bvo.setTitle(rs.getString("title"));
				bvo.setWriter(rs.getString("writer"));
				bvo.setRegdate(rs.getTimestamp("regdate"));
				bvo.setHit(rs.getInt("hit"));
				list.add(bvo);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return list;
	}

	public BoardVO read(BoardVO bvo) {
		BoardVO vo = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		StringBuffer query = new StringBuffer();
		query.append(" SELECT b.board_id, b.title, b.content, m.uname as writer, b.regdate, b.hit ");
		query.append(" FROM board as b JOIN member as m ");
		query.append(" ON b.writer = m.id ");
		query.append(" WHERE board_id = ? ");
		String sql = query.toString();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, bvo.getBoard_id());
			rs = stmt.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setBoard_id(rs.getInt("board_id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegdate(rs.getTimestamp("regdate"));
				vo.setHit(rs.getInt("hit"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {

			}
		}

		return vo;
	}
}
