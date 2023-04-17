package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;

public class MemberModifyUI extends BaseUI {
	
	private MemberService memberService;
	
	public MemberModifyUI() {
		
		memberService = new MemberService();
	}

	@Override
	public void execute() throws Exception {
		
		System.out.println("비밀번호를 한 번 더 입력해 주세요.");
		String pw = scanStr("비밀번호 : ");
		
		ILibraryUI ui = null;
		if (memberService.logIn(id, pw)) {
		
	}

	
}
