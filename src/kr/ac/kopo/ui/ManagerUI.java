package kr.ac.kopo.ui;

public class ManagerUI extends BaseUI {
	
	
	public ManagerUI() {

	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("======================================");
		System.out.println("\t관리자 페이지입니다.");
		System.out.println("======================================");
		
		ILibraryUI ui = null;
		while (true) {
			int manage = scanInt("1. 보유도서 목록 2. 도서정보 추가 3. 도서정보 수정 4. 도서정보 삭제 5. 대출현황 6. 로그아웃 0. 종료\n");
			
			switch (manage) {
			case 1:
				ui = new BookAllUI();
				break;
			case 2:
				ui = new BookAddUI();
				break;
			case 3:
				ui = new BookModifyUI();
				break;
			case 4:
				ui = new BookDeleteUI();
				break;	
			case 5:
				ui = new RentStatusUI();
				break;
			case 6:
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
