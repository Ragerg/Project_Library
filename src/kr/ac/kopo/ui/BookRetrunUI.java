package kr.ac.kopo.ui;

import kr.ac.kopo.service.RentService;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentVO;

public class BookRetrunUI extends BaseUI {

    private RentService rentService;
    private MemberVO memberVo;

    public BookRetrunUI() {

        rentService = new RentService();
        memberVo = new MemberVO();
    }

    public BookRetrunUI(MemberVO memberVo) {
        this();
        this.memberVo = memberVo;
    }

    @Override
    public void execute() throws Exception {

        String id = memberVo.getId();

        System.out.println("\n\n======================================");
        System.out.println("\t\t도서반납");
        System.out.println("======================================\n");

        int regNo = scanInt("\n반납하실 도서의 도서번호를 입력해 주세요 : ");

        try {
            RentVO rent = new RentVO();
            rent.setRegNo(regNo);
            rent.setRentId(id);

            if (rentService.returnBookCheck(rent)) {
                rentService.returnBook(rent);
                System.out.println("\n도서반납을 완료하였습니다");
            } else {
                System.out.println("\n!반납할 수 없는 도서입니다.");
                execute();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
