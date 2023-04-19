package kr.ac.kopo.ui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class BookAddUI extends BaseUI {
	
	private BookService bookService;
	
	public BookAddUI() {
		
		bookService = new BookService();
	}
	

	@Override
	public void execute() throws Exception {
		
		System.out.println("======================================");
		System.out.println("\t도서정보 입력");
		System.out.println("======================================");
		
		String title = scanStr("제목 : ");
		String writer = scanStr("저자 : ");
		String publisher = scanStr("출판사 : ");
		int issueYear = scanInt("발행연도 : ");
		
		while (issueYear > 9999 || issueYear < 999) {
			System.out.println("발행연도는 4자리를 넘을 수 없습니다.");
			System.out.println("다시 입력해주세요.");
			issueYear = scanInt("발행연도 : ");
		}
		
		BookVO book = new BookVO();
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setIssueYear(issueYear);
		
		bookService.insertBook(book);
		
		System.out.println("도서추가를 완료하였습니다");
		
	}

}
