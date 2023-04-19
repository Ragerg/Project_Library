package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberModifyUI extends BaseUI {

	private MemberService memberService;
	private MemberVO memberVo;

	public MemberModifyUI() {

		memberService = new MemberService();
	}

	public MemberModifyUI(MemberVO memberVo) {
		memberService = new MemberService();
		this.memberVo = memberVo;
	}

	@Override
	public void execute() throws Exception {

			String id = memberVo.getId();
			System.out.println("비밀번호를 한 번 더 입력해 주세요.");
			String pw = scanStr("비밀번호 : ");

		while (true) {
			ILibraryUI ui = null;
			if (memberService.logIn(id, pw)) {
				
				System.out.println("수정할 사항을 선택해 주세요.");

				int choice = scanInt("1. 비밀번호 2. 이름 3. 주소 4. 핸드폰 번호 5. 수정완료 0. 종료\n");

				switch (choice) {
				case 1:
					System.out.println("변경하실 비밀번호를 입력해 주세요.");
					pw = scanStr("비밀번호 : ");
					StringBuilder sql = new StringBuilder();
					sql.append("update t_member ");
					sql.append(" set pw = ? ");
					sql.append(" where id = ? ");
					
					try(
						Connection conn = new ConnectionFactory().getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
						pstmt.setString(1, pw);
						pstmt.setString(2, id);
						
						pstmt.executeUpdate();
						
						System.out.println("비밀번호가 수정되었습니다.");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 2:
					System.out.println("변경하실 이름을 입력해 주세요.");
					String name2 = scanStr("이름 : ");
					sql = new StringBuilder();
					sql.append("update t_member ");
					sql.append(" set name = ? ");
					sql.append(" where id = ? ");
					
					try(
						Connection conn = new ConnectionFactory().getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
						pstmt.setString(1, name2);
						pstmt.setString(2, id);
						
						pstmt.executeUpdate();
						
						System.out.println("이름이 수정되었습니다.");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 3:
					System.out.println("변경하실 주소를 입력해 주세요.");
					String address2 = scanStr("주소(군/구 까지 입력) : ");
					sql = new StringBuilder();
					sql.append("update t_member ");
					sql.append(" set address = ? ");
					sql.append(" where id = ? ");
					
					try(
						Connection conn = new ConnectionFactory().getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
						pstmt.setString(1, address2);
						pstmt.setString(2, id);
						
						pstmt.executeUpdate();
						
						System.out.println("주소가 수정되었습니다.");
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("변경하실 핸드폰 번호를 입력해 주세요.");
					String phoneNum2 = scanStr("핸드폰 번호(- 없이 숫자만 입력): ");
					
					while (phoneNum2.length() > 11 ) {
						System.out.println("핸드폰 번호는 11글자를 넘을 수 없습니다.");
						System.out.println("다시 입력해주세요.");
						phoneNum2 = scanStr("핸드폰 번호(- 없이 숫자만 입력): ");
					}
					
					sql = new StringBuilder();
					sql.append("update t_member ");
					sql.append(" set phone_num = ? ");
					sql.append(" where id = ? ");
					
					try(
						Connection conn = new ConnectionFactory().getConnection();
						PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
						pstmt.setString(1, phoneNum2);
						pstmt.setString(2, id);
						
						pstmt.executeUpdate();
						
						System.out.println("핸드폰 번호가 수정되었습니다.");
					}catch(Exception e) {
						e.printStackTrace();
					}
					break;
				case 5 :
					ui = new MemberPageUI(memberVo);
					ui.execute();
					break;
				case 0:
					ui = new ExitUI();
					ui.execute();
					break;
				default : System.out.println("잘못 입력하셨습니다");
					
				}

			} else {
				System.out.println("비밀번호가 옳바르지 않습니다.");
				execute();
			}

		}
	}

}
