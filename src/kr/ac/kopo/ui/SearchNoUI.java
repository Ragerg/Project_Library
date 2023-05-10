package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.vo.BookVO;

public class SearchNoUI extends BaseUI {

    private BookService service;
    private int regNo;

    public SearchNoUI() {
        service = new BookService();
    }

    public SearchNoUI(int regNo) {
        this();
        this.regNo = regNo;
    }

    @Override
    public void execute() throws Exception {

        List<BookVO> bookList = service.Search(regNo);

        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
        System.out.printf("%4s\t%-20s\t%-15s\t\t%-15s\t%-10s\t%-10s\n", "도서번호", "제목", "저자", "출판사", "발행연도", "대출상태");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");

        if (bookList == null || bookList.size() == 0) {
            System.out.println("보유도서가 존재하지 않습니다");
        } else {
            for (BookVO book : bookList) {
                System.out.printf(" %03d\t", book.getRegNo());
                System.out.printf("%-20s\t", book.getTitle());
                System.out.printf("%-15s\t", book.getWriter());
                System.out.printf("%-15s\t", book.getPublisher());
                System.out.printf("%-10d\t", book.getIssueYear());
                System.out.printf("%-10s\n", book.getStatus());
            }
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------");
    }

}
