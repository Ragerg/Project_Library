package kr.ac.kopo.ui;

import kr.ac.kopo.vo.MemberVO;

public class BookSearchUI extends BaseUI{
	
	private MemberVO memberVo;
	
	public BookSearchUI() {
		memberVo = new MemberVO();
	}
	
	public BookSearchUI(MemberVO memberVo) {
		this();
		this.memberVo = memberVo;
	}

	@Override
	public void execute() throws Exception {
		
		while (true) {
			ILibraryUI ui = null;
			String id = memberVo.getId();
			int search = scanInt("1. 보유도서 목록 2. 제목으로 검색 3. 저자로 검색 4. 도서 대출 5. 마이페이지 0. 종료\n");
			
			switch (search) {
			case 1:
				ui = new BookAllUI();
				break;
			case 2:
				ui = new SearchUI("title");
				break;
			case 3:
				ui = new SearchUI("writer");
				break;
			case 4 :
				ui = new BookRentUI(memberVo);
				break;
			case 5:
				ui = new MemberPageUI(memberVo);
				break;
			case 0:
				ui = new ExitUI();
				break;
				
			}
			if (ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못 입력하셨습니다");
			}
		}


	}

}
