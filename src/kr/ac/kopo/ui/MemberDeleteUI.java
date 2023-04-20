package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDeleteUI extends BaseUI {

	private MemberService memberService;
	private MemberVO memberVo;

	public MemberDeleteUI() {
		memberService = new MemberService();
		memberVo = new MemberVO();

	}

	public MemberDeleteUI(MemberVO memberVo) {
		this();
		this.memberVo = memberVo;
	}

	@Override
	public void execute() throws Exception {

		String id = memberVo.getId();
		System.out.println("비밀번호를 한 번 더 입력해 주세요.");
		String pw = scanStr("비밀번호 : ");

		if (memberService.logIn(id, pw)) {

			StringBuilder sql = new StringBuilder();
			sql.append("delete t_member ");
			sql.append(" where id = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				pstmt.setString(1, id);

				pstmt.executeUpdate();

				System.out.println("탈퇴되었습니다.");
				ILibraryUI ui = new LibraryUI();
				ui.execute();
			} catch (Exception e) {
				System.out.println("대출중인 도서가 있는 경우 탈퇴할 수 없습니다.");
				System.out.println("마이페이지로 돌아갑니다.");
				ILibraryUI ui = new MemberPageUI(memberVo);
				ui.execute();
			}

		} else {
			System.out.println("비밀번호가 다릅니다.");
			System.out.println("마이페이지로 돌아갑니다.");
		}
	}
}
