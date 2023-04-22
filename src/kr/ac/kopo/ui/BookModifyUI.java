package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.ConnectionFactory;

public class BookModifyUI extends BaseUI {

	private BookService bookService;

	public BookModifyUI() {
		bookService = new BookService();

	}

	@Override
	public void execute() throws Exception {

		while (true) {
			ILibraryUI ui = null;
			
			System.out.println("\n수정할 사항을 선택해 주세요.");
			int choice = scanInt("1. 제목 2. 저자 3. 출판사 4. 발행연도 5. 수정완료 0. 종료\n");

			switch (choice) {
			case 1:
				int regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				if (!bookService.noCheck(regNo)) {
					System.out.println("\n!없는 도서입니다.");
					System.out.println("다시 입력해 주세요.");
					
					regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				};
				String title2 = scanStr("\n제목 : ");
				StringBuilder sql = new StringBuilder();
				sql.append("update t_book ");
				sql.append(" set title = ? ");
				sql.append(" where reg_no = ? ");
				
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					pstmt.setString(1, title2);
					pstmt.setInt(2, regNo);
					
					pstmt.executeUpdate();
					
					System.out.println("\n제목이 수정되었습니다.\n");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				ui = new SearchNoUI(regNo);
				break;
			case 2:
				regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				if (!bookService.noCheck(regNo)) {
					System.out.println("\n!없는 도서입니다.");
					System.out.println("다시 입력해 주세요.");
					
					regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				};
				String writer2 = scanStr("\n저자 : ");
				sql = new StringBuilder();
				sql.append("update t_book ");
				sql.append(" set writer = ? ");
				sql.append(" where reg_no = ? ");
				
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					pstmt.setString(1, writer2);
					pstmt.setInt(2, regNo);
					
					pstmt.executeUpdate();
					
					System.out.println("\n저자명이 수정되었습니다.\n");
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				ui = new SearchNoUI(regNo);
				break;
			case 3:
				regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				if (!bookService.noCheck(regNo)) {
					System.out.println("없는 도서입니다.");
					System.out.println("다시 입력해 주세요.");
					
					regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				};
				String publisher2 = scanStr("\n출판사 : ");
				sql = new StringBuilder();
				sql.append("update t_book ");
				sql.append(" set publisher = ? ");
				sql.append(" where reg_no = ? ");
				
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					pstmt.setString(1, publisher2);
					pstmt.setInt(2, regNo);
					
					pstmt.executeUpdate();
					
					System.out.println("\n출판사가 수정되었습니다.\n");
				}catch(Exception e) {
					e.printStackTrace();
				}
				ui = new SearchNoUI(regNo);
				break;
			case 4:
				regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				if (!bookService.noCheck(regNo)) {
					System.out.println("없는 도서입니다.");
					System.out.println("다시 입력해 주세요.");
					
					regNo = scanInt("\n수정할 도서의 도서번호를 입력해 주세요. : ");
				};
				
				
				int issueYear2 = scanInt("\n발행연도 : ");
				while (issueYear2 > 9999 || issueYear2 <= 999) {
					System.out.println("!발행연도는 숫자 4자리입니다.");
					System.out.println("다시 입력해주세요.");
					issueYear2 = scanInt("발행연도 : ");
				}
				sql = new StringBuilder();
				sql.append("update t_book ");
				sql.append(" set issue_Year = ? ");
				sql.append(" where reg_no = ? ");
				
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
					pstmt.setInt(1, issueYear2);
					pstmt.setInt(2, regNo);
					
					pstmt.executeUpdate();
					
					System.out.println("\n발행연도가 수정되었습니다.\n");
				}catch(Exception e) {
					e.printStackTrace();
				}
				ui = new SearchNoUI(regNo);
				break;
			case 5 :
					ui = new ManagerUI();
					break;
			case 0:
				ui = new ExitUI();
				break;
			default : System.out.println("\n!잘못 입력하셨습니다");
				
			}
			ui.execute();

		}
	}

}
