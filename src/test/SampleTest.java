package test;

import java.util.Iterator;
import java.util.List;

import dao.sampleDAO;
import domain.SampleVO;

public class SampleTest {

	public static void main(String[] args) {
		sampleDAO dao = new sampleDAO();
//		SampleVO vo = new SampleVO();
//		vo.setStrData("문자데이터");
//
//		 dao.create(vo);

//		List<SampleVO> list = dao.read();
//		Iterator<SampleVO> it = list.iterator();
//		while(it.hasNext()) {
//			SampleVO svo = it.next();
//			System.out.print(svo.getNum()+"\t");
//			System.out.print(svo.getStrData()+"\t");
//			System.out.println(svo.getSampleDate()+"\t");
//		}
		
		
//		SampleVO vo2 = new SampleVO();
//		vo2.setNum(1);
//
//		SampleVO sampleVO = dao.read(vo2);
//		System.out.print(sampleVO.getNum() + "\t");
//		System.out.print(sampleVO.getStrData() + "\t");
//		System.out.println(sampleVO.getSampleDate() + "\t");
		
		
		SampleVO vo2 = new SampleVO();
		vo2.setNum(9);
//		vo2.setStrData("변경되었나요?");
//		dao.update(vo2);
		dao.delete(vo2);
		
	}

}
