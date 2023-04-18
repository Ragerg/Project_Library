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
		
		System.out.println("----------------------------------------------------------------------");
		System.out.println("대여번호\t등록번호\t제목\t\t대출회원\t대출일\t\t반납예정일");
		System.out.println("----------------------------------------------------------------------");
		
		if(rentList == null || rentList.size() == 0) {
			System.out.println("대출도서가 존재하지 않습니다");
		} else {
			for(RentVO rent : rentList) {
				System.out.println(rent.getRentNo() + "\t" +rent.getRegNo() + "\t" 
			+ rent.getTitle() + "\t\t" + rent.getRentId() + "\t" + rent.getRentDate() + "\t" + rent.getReturnDate());
			}
		}
		System.out.println("---------------------------------------------------------------------");
	}
}
