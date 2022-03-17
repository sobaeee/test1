package test;

import java.util.Iterator;
import java.util.List;

import dao.BoardDAO;
import domain.BoardDTO;
import domain.BoardVO;

public class BoardTest {

	public static void main(String[] args) {
//		BoardVO bvo = null;
		//글등록		
//		BoardVO bvo = new BoardVO();
//		bvo.setWriter("hijimi");
//		bvo.setTitle("고양이");
//		bvo.setContent("야옹야옹");
//		new BoardDAO().create(bvo);
		// System.out.println(bvo.toString());

		// 글목록
//		List<BoardVO> list = new BoardDAO().read();
//		Iterator<BoardVO> it = list.iterator();
//		while(it.hasNext()) {
//			bvo = it.next();
//			
//			System.out.printf("%d\t %s\t %s\t %s\t %d\n", 
//					bvo.getBoard_id(),
//					bvo.getTitle(), 
//					bvo.getWriter(), 
//					bvo.getRegdate(), 
//					bvo.getHit());
//		}

		// 목록조회
//		BoardDTO bdto = new BoardDTO();
//		bdto.setSfl("title|content"); //title, content
//		bdto.setKeyword("시");
//
//		List<BoardVO> list = new BoardDAO().read(bdto);
//		Iterator<BoardVO> it = list.iterator();
//		while (it.hasNext()) {
//			bvo = it.next();
//
//			System.out.printf("%d\t %s\t %s\t %s\t %d\n", bvo.getBoard_id(), bvo.getTitle(), bvo.getWriter(),
//					bvo.getRegdate(), bvo.getHit());
//		}
		// 해당글 조회
		BoardVO vo = new BoardVO();
		vo.setBoard_id(6);

		BoardVO bvo = new BoardDAO().read(vo);
		if (bvo != null) {

			System.out.printf("%d\t %s\t %s\t %s\t %s\t %d\n", bvo.getBoard_id(), bvo.getTitle(), bvo.getContent(),
					bvo.getWriter(), bvo.getRegdate(), bvo.getHit());
		} else {
			System.out.println("해당 글이 없습니다.");
		}
	}
}