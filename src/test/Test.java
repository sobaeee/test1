package test;

import java.sql.Timestamp;
import java.util.Date;

import dao.ExamDAO;
import domain.ExamVO;
//import test.dao.Simple2DAO;

public class Test {

	public static void main(String[] args) {
		ExamDAO dao = new ExamDAO();
		
		ExamVO createVo = new ExamVO(0, "가변폭문자열", "고정폭문자열", 0.123, new Date(), new Timestamp(System.currentTimeMillis()));
		//생성자를 이용해서 객체를 만들었다.
		
		//System.out.println(createVo);
		dao.create(createVo);
		//()에 createVo를 넣었어니 create에 오류가 났다. ExamDAO의 create창 옆 ()에 ExamVO createVo 넣으면 오류 해결..
		
		
		
		
		
		
		
//		Simple2DAO dao = new Simple2DAO();
//		//dao.create();
//		//dao.read();
//		//dao.update();
//		dao.delete();
//		simple2DAO랑 연결되어 있음.
		
	}

}
