package kr.ac.kopo.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.util.ConnectionFactory;

public class BookDeleteUI extends BaseUI {

	private BookService bookService;

	public BookDeleteUI() {
		bookService = new BookService();

	}

	@Override
	public void execute() throws Exception {

			ILibraryUI ui = null;

			int regNo = scanInt("삭제할 도서의 도서번호를 입력해 주세요.(0 입력 시 이전 페이지)");

			if (!bookService.noCheck(regNo)) {
				if(regNo == 0) {
					return;
				}
				System.out.println("없는 도서입니다.");
				System.out.println("다시 입력해 주세요.");

				regNo = scanInt("삭제할 도서의 도서번호를 입력해 주세요.");
			};
			

			StringBuilder sql = new StringBuilder();
			sql.append("delete t_book ");
			sql.append(" where reg_no = ? ");

			try (Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				pstmt.setInt(1, regNo);

				pstmt.executeUpdate();

				System.out.println("도서정보가 삭제되었습니다.");
			}catch(Exception e) {
				System.out.println("대출 중인 도서는 삭제할 수 없습니다.");
				execute();
			}	

		}

	
}
