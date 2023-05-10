package kr.ac.kopo.service;

import java.util.List;

import kr.ac.kopo.dao.RentDAO;
import kr.ac.kopo.vo.RentVO;

public class RentService {

    private RentDAO rentDao;

    public RentService() {
        rentDao = new RentDAO();
    }

    // 책 대여
    public void rentBook(RentVO rent) throws Exception {

        rentDao.rentBook(rent);
    }

    // 관리자 - 대여 목록
    public List<RentVO> rentAll() {
        List<RentVO> rentList = rentDao.rentAll();
        return rentList;
    }

    // 회원 - 대여 목록
    public List<RentVO> rentMember(String id) {
        List<RentVO> rentList = rentDao.rentMember(id);
        return rentList;
    }

    // 반납
    public void returnBook(RentVO rent) throws Exception {
        rentDao.returnBook(rent);
    }

    public boolean returnBookCheck(RentVO rent) throws Exception {
        return rentDao.returnBookCheck(rent);
    }

}
