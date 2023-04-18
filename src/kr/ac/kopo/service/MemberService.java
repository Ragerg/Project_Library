package kr.ac.kopo.service;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.vo.MemberVO;

public class MemberService {
	
	private MemberDAO memberDao;
	
	public MemberService() {
		memberDao = new MemberDAO();
	}
	
	// 회원가입 멤버 추가
	public void insertMember(MemberVO member) {

		memberDao.insertMember(member);
	}
	
	// 회원가입 시 아이디 중복 체크
	public boolean idCheck(String id) {
		
		return memberDao.idCheck(id);
		
	}
	
	// 로그인 시 아이디, 비밀번호 체크
	public boolean logIn(String id, String pw) {
		
		return memberDao.logIn(id, pw);
		
	}
	
	// 마이페이지
	public MemberVO MemberPage(String id) {
		return memberDao.MemberPage(id);
	}
	
	
	
	
	

}
