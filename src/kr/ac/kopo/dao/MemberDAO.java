package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {
	
	//회원가입 시 멤버 추가
	public void insertMember(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, pw, name, address, phone_num) ");
		sql.append(" values(?, ?, ?, ?, ?) ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getPhoneNum());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 시 중복 아이디 체크
	public boolean idCheck(String id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id from t_member where id = ? ");
		boolean idcheck = false;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			idcheck = rs.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return idcheck;
	}
	
	//로그인
	public boolean logIn(String id, String pw) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id from t_member where id = ? and pw = ?");
		boolean logIn = true;
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			ResultSet rs = pstmt.executeQuery();
			
			logIn = rs.next();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return logIn;
	}

	
}