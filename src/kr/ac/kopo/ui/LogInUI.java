package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class LogInUI extends BaseUI {

	private MemberService memberService;
	private MemberVO memberVo;

	public LogInUI() {
		memberService = new MemberService();
		memberVo = new MemberVO();

	}

	@Override
	public void execute() throws Exception {

		System.out.println("\n\n======================================");
		System.out.println("\t\t로그인");
		System.out.println("======================================\n");

		String id = scanStr("아이디 : ");
		String pw = scanStr("비밀번호 : ");

		ILibraryUI ui = null;
		if (memberService.logIn(id, pw)) {
			memberVo.setId(id);
			System.out.println("\n로그인 완료");

			if (id.equals("admin01")) {
				
				ui = new ManagerUI();
				ui.execute();
				
			} else {
				
				System.out.println( id + " 님 반갑습니다.");
				System.out.println( "\n메뉴를 선택해 주세요.");

				while (true) {
					int choice = scanInt("1. 도서검색 2. 마이페이지 3. 로그아웃 0. 종료\n");

					switch (choice) {
					case 1:
						ui = new BookSearchUI(memberVo);
						break;
					case 2:
						ui = new MemberPageUI(memberVo);
						break;
					case 3:
						ui = new LibraryUI();
						break;
					case 0:
						ui = new ExitUI();
						break;
					}

					if (ui != null) {
						ui.execute();
					} else {
						System.out.println("\n!잘못 입력하셨습니다");
					}
				}
			}

		} else {

			while (true) {
				System.out.println("아이디 또는 비밀번호가 틀렸습니다.");
				System.out.println("다시 입력해 주세요.");
				int again = scanInt("1. 로그인 2. 메인으로 나가기 0. 종료\n");

				switch (again) {
				case 1:
					execute();
					break;
				case 2:
					ui = new LibraryUI();
					break;
				case 0:
					ui = new ExitUI();
					break;
				}

				if (ui != null) {
					ui.execute();
				} else {
					System.out.println("\n!잘못 입력하셨습니다");
				}
			}
		}

	}

}
