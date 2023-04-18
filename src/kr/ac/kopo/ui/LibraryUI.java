package kr.ac.kopo.ui;

import java.util.Scanner;

public class LibraryUI extends BaseUI {
	
	private int menu() {
		System.out.println("*** 라개 도서관 ***");
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 종료");
		System.out.println("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();
		
		return type;
	}
	
	public void execute() throws Exception {
		while(true) {
			int type = menu();
			ILibraryUI ui = null;
			switch(type) {
			 case 1 :
				 ui = new LogInUI();
				 break;
			 case 2 :
				 ui = new JoinMemberUI();
				 break;
			 case 0 :
				 ui = new ExitUI();
				 break;
		 	}
			
			if(ui != null) {
				ui.execute();
			} else {
				System.out.println("잘못 입력하셨습니다");
			}
		}
	}

}
