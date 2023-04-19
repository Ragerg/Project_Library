package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.service.RentService;
import kr.ac.kopo.vo.RentVO;

public class RentStatusUI extends BaseUI {
	
	private RentService rentService;
	
	public RentStatusUI() {
		rentService = new RentService();
	}
	

	@Override
	public void execute() throws Exception {
		List<RentVO> rentList = rentService.rentAll();
		
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.printf("%4s\t%4s\t%-20s\t%-10s\t%-10s\t%-10s\n", "대여번호","도서번호", "제목", "대출회원", "대출일", "반납예정일");
		System.out.println("--------------------------------------------------------------------------------------");
		
		if(rentList == null || rentList.size() == 0) {
			System.out.println("대출도서가 존재하지 않습니다");
		} else {
			for(RentVO rent : rentList) {
				System.out.printf(" %3d\t", rent.getRentNo());
				System.out.printf(" %03d\t", rent.getRegNo());
				System.out.printf("%-20s\t", rent.getTitle());
				System.out.printf("%-10s\t", rent.getRentId());
				System.out.printf("%-10s\t", rent.getRentDate());
				System.out.printf("%-10s\n", rent.getReturnDate());
			
			
//				System.out.println(rent.getRentNo() + "\t" +rent.getRegNo() + "\t" 
//			+ rent.getTitle() + "\t\t" + rent.getRentId() + "\t" + rent.getRentDate() + "\t" + rent.getReturnDate());
			}
		}
		System.out.println("--------------------------------------------------------------------------------------");
	}
}
