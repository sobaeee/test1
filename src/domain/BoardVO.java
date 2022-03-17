package domain;

import java.io.Serializable;
import java.sql.Timestamp;

// Serializable : 객체 직렬화. 하나씩 나열한다.

public class BoardVO implements Serializable {
	//멤버변수(속성) = 필드 
	private int board_id;
	private String writer;
	private String title;
	private String content;
	private Timestamp regdate; //date는 java.util을 사용할것. 
	private int hit;
	//생성자
	public BoardVO() {
	}
	//생성자
	public BoardVO(int board_id, String writer, String title, String content, Timestamp regdate, int hit) {
		super();
		this.board_id = board_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regdate = regdate;
		this.hit = hit;
	}
	
	//객체 디버깅할때 유용함
	@Override
	public String toString() {
		return "BoardVO [board_id=" + board_id + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", regdate=" + regdate + ", hit=" + hit + "]";
	}

	public int getBoard_id() {
		return board_id;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
