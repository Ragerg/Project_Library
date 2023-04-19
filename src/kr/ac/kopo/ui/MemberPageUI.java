package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.RentService;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentVO;

public class MemberPageUI extends BaseUI {

	private MemberService memberService;
	private RentService rentService;
	private MemberVO memberVo;

	public MemberPageUI() {
		memberService = new MemberService();
		rentService = new RentService();
		memberVo = new MemberVO();

	}
	
	public MemberPageUI(MemberVO memberVo) {
		this();
		this.memberVo = memberVo;
	}

	@Override
	public void execute() throws Exception {
		
		while (true) {
		String id = memberVo.getId();
		MemberVO member = memberService.MemberPage(id);
		List<RentVO> rentList = rentService.rentMember(id);

		System.out.println("============================================================");
		System.out.println("\t\t\t마이페이지");
		System.out.println("============================================================");

		System.out.println(memberVo.getId() + "님");
		System.out.println("이름 : " + member.getName());
		System.out.println("주소 : " + member.getAddress());
		System.out.println("핸드폰 번호 : " + member.getPhoneNum());
		System.out.println("\n<< 대여목록 >>");
		System.out.println("------------------------------------------------------------");
		System.out.printf("%4s\t%-20s\t%-10s\t%-10s\n", "도서번호", "제목", "대출일", "반납예정일");
		System.out.println("------------------------------------------------------------");
		
		
		if(rentList == null || rentList.size() == 0) {
			System.out.println("대출도서가 존재하지 않습니다");
		} else {
			for(RentVO rent : rentList) {
				System.out.printf(" %03d\t", rent.getRegNo());
				System.out.printf("%-20s\t", rent.getTitle());
				System.out.printf("%-10s\t", rent.getRentDate());
				System.out.printf("%-10s\n", rent.getReturnDate());
			}
		}
		System.out.println("------------------------------------------------------------");
		
		System.out.println("============================================================");
		System.out.println();
		
		System.out.println("메뉴를 선택해 주세요.");

			ILibraryUI ui = null;
			int choice = scanInt("1. 도서검색 2. 대여하기 3. 반납하기 4. 회원정보 수정 5. 로그아웃 6. 회원탈퇴 0. 종료\n");
			switch (choice) {
			case 1 :
				ui = new BookSearchUI(memberVo);
				break;
			case 2:
				ui = new BookRentUI(memberVo);
				break;
			case 3:
				ui = new BookRetrunUI(memberVo);
				break;
			case 4:
				ui = new MemberModifyUI(memberVo);
				break;
			case 5:
				ui = new LibraryUI();
				break;
			case 6:
				ui = new MemberDeleteUI(memberVo);
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
