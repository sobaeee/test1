package test;

import dao.MemberDAO;
import domain.MemberVO;

public class MemberTest {

	public static void main(String[] args) {
		MemberVO mvo = new MemberVO(); 
		mvo.setId("joy123");
		mvo.setPw("56789");
		mvo.setUname("이지미");
		//System.out.println(mvo);
		new MemberDAO().create(mvo);
	}
	
}
