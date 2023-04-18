package kr.ac.kopo.ui;

import kr.ac.kopo.service.BookService;
import kr.ac.kopo.service.RentService;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentVO;

public class BookRentUI extends BaseUI{
	
	private RentService rentService;
	private BookService bookService;
	private MemberVO memberVo;
	
	
	public BookRentUI() {
		
		rentService = new RentService();
		bookService = new BookService();
		memberVo = new MemberVO();
	}
	
	public BookRentUI(MemberVO memberVo) {
		this();
		this.memberVo = memberVo;
	}
	

	@Override
	public void execute() throws Exception {
		
		String id = memberVo.getId();
		
		System.out.println("======================================");
		System.out.println("\t\t도서대출");
		System.out.println("======================================");
		
		int regNo = scanInt("대출하실 도서의 도서번호를 입력해 주세요 : ");
		
		if (!bookService.noCheck(regNo)) {
			System.out.println("대출할 수 없는 도서입니다.");
			System.out.println("다시 입력해 주세요.");
			
			regNo = scanInt("대출하실 도서의 도서번호를 입력해 주세요 : ");
		};
		
		try {
			RentVO rent = new RentVO();
			rent.setRegNo(regNo);
			rent.setRentId(id);
			rentService.rentBook(rent);
			
			System.out.println("도서대출을 완료하였습니다");
		} catch(Exception e) {
			System.out.println("대출할 수 없는 도서입니다.");
			execute();
		}
		
		
	}
		

}
