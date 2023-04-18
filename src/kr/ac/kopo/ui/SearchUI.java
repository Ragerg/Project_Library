package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchUI extends BaseUI {

	private BookService service;
	private BookVO book;
	String torw;
	
	public SearchUI() {
		service = new BookService();
		book = new BookVO();
	}
	
	public SearchUI(String torw) {
		this();
		this.torw = torw;
	}
	
	@Override
	public void execute() throws Exception {
		

		String str = scanStr("검색할 내용을 입력하세요 : ");
		List<BookVO> bookList = service.Search(torw, str);
		
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
