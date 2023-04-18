package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class BookAllUI extends BaseUI {
	
	private BookService bookService;
	
	public BookAllUI() {
		bookService = new BookService();
	}
	

	@Override
	public void execute() throws Exception {
		List<BookVO> bookList = bookService.selectAll();
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("도서번호\t제목\t저자\t출판사\t발행연도\t대출상태");
		System.out.println("---------------------------------------------------------------");
		
		if(bookList == null || bookList.size() == 0) {
			System.out.println("보유도서가 존재하지 않습니다");
		} else {
			for(BookVO book : bookList) {
				System.out.println(book.getRegNo() + "\t" + book.getTitle() + "\t" + book.getWriter() + "\t" + book.getPublisher()  + "\t" + book.getIssueYear() + "\t" + book.getStatus());
			}
		}
		System.out.println("---------------------------------------------------------------");
	}
}
