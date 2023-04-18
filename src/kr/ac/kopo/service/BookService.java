package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.BookDAO;
import kr.ac.kopo.vo.BookVO;

public class BookService {

	private BookDAO bookDao;

	public BookService() {
		bookDao = new BookDAO();
	}

	// 책 추가
	public void insertBook(BookVO book) {

		bookDao.insertBook(book);
	}
	
	// 보유장서 목록
	public List<BookVO> selectAll() {
		List<BookVO> bookList = bookDao.selectAllBook();
		return bookList;
	}
	
	// 도서정보 수정 시 보유장서인지 체크
	public boolean noCheck(int regNo) {
		return bookDao.noCheck(regNo);
	}

	// 책 검색
	public List<BookVO> Search(String torw, String str) {
		return bookDao.search(torw, str);
	}


}
