package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;

public class RogInUI extends BaseUI {
	
	private MemberService memberService;
	
	public RogInUI() {
		memberService = new MemberService();
		
	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("======================================");
		System.out.println("\t\t로그인");
		System.out.println("======================================");
		
		String id = scanStr("아이디 : ");
		String pw = scanStr("비밀번호 : ");
	
		
		ILibraryUI ui = null;
		if (memberService.logIn(id, pw)) {
			
			System.out.println("로그인 완료");
			int choice = scanInt("1. 도서검색 2. 회원정보 수정 3. 메인으로 나가기\n 0. 종료");
			
			switch (choice) {
			case 1 :
				;
				break;
			case 2 :
				;
				break;
			case 3 :
				break;
			case 0 :
				 ui = new ExitUI();
				 break;
			}
			
		} else {
			System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
			System.out.println("다시 입력해 주세요.");
			int again = scanInt("1. 로그인 2. 메인으로 나가기\n 0. 종료");
			
			switch (again) {
			case 1 :
				execute();
				break;
			case 2 :
				break;
			case 0 :
				 ui = new ExitUI();
				 break;
			}
			
			
		}
		
	}
	
	

}
