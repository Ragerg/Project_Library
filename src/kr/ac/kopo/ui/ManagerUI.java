package kr.ac.kopo.ui;

public class ManagerUI extends BaseUI {
	
	
	public ManagerUI() {

	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("\n\n======================================");
		System.out.println("\t관리자 페이지입니다.");
		System.out.println("======================================\n");
		
		ILibraryUI ui = null;
		while (true) {
			System.out.println("\n메뉴를 선택해 주세요.");
			System.out.println("1. 보유도서 목록 2. 제목으로 검색 3. 저자로 검색 4. 출판사로 검색 ");
			int manage = scanInt("5.도서정보 추가 6. 도서정보 수정 7. 도서정보 삭제 8. 대출현황 9. 로그아웃 0. 종료\n");
			
			switch (manage) {
			case 1:
				ui = new BookAllUI();
				break;
			case 2:
				ui = new SearchUI("title");
				break;
			case 3:
				ui = new SearchUI("writer");
				break;
			case 4:
				ui = new SearchUI("publisher");
				break;	
			case 5:
				ui = new BookAddUI();
				break;
			case 6:
				ui = new BookModifyUI();
				break;
			case 7:
				ui = new BookDeleteUI();
				break;	
			case 8:
				ui = new RentStatusUI();
				break;
			case 9:
				ui = new LibraryUI();
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
