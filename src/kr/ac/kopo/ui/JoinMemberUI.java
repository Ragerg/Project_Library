package kr.ac.kopo.ui;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.vo.MemberVO;

public class JoinMemberUI extends BaseUI{
	
	private MemberService memberService;
	
	public JoinMemberUI() {
		
		memberService = new MemberService();
	}
	

	@Override
	public void execute() throws Exception {
		
		System.out.println("======================================");
		System.out.println("\t\t회원가입");
		System.out.println("======================================");
		
		String id = scanStr("아이디 : ");
		if (memberService.idCheck(id)) {
			System.out.println("중복되는 아이디입니다.");
			System.out.println("다시 입력해 주세요.");
			
			id = scanStr("아이디 : ");
		};
		String pw = scanStr("비밀번호 : ");
		String name = scanStr("이름 : ");
		String address = scanStr("주소(군/구 까지 입력) : ");
		String phoneNum = scanStr("핸드폰 번호(- 없이 숫자만 입력): ");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setAddress(address);
		member.setPhoneNum(phoneNum);
		
		memberService.insertMember(member);
		
		System.out.println("회원가입을 완료하였습니다");
		
	}

}
