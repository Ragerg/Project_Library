package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.RentVO;

public class RentDAO {

	// 책 대출
	public void rentBook(RentVO rent) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_b_status(rent_no, reg_no, rent_id) ");
		sql.append(" values(seq_t_b_status_rent_no.nextval, ?, ?) ");

		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		pstmt.setInt(1, rent.getRegNo());
		pstmt.setString(2, rent.getRentId());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

	}

	// 관리자 - 대출목록
	public List<RentVO> rentAll() {

		List<RentVO> rentList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select rent_no, b1.reg_no, title, rent_id, rent_date, return_date ");
		sql.append(" from t_b_status s1 ");
		sql.append(" join t_book b1 on b1.reg_no = s1.reg_no ");
		sql.append(" order by rent_date ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int rentNo = rs.getInt("rent_no");
				int regNo = rs.getInt("reg_no");
				String title = rs.getString("title");
				String rentId = rs.getString("rent_id");
				String rentDate = rs.getString("rent_date");
				String returnDate = rs.getString("return_date");

				RentVO rent = new RentVO(rentNo, regNo, title, rentId, rentDate, returnDate);

				rentList.add(rent);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentList;

	}

	// 회원 - 대출목록
	public List<RentVO> rentMember(String id) {
		List<RentVO> rentList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select s1.reg_no, title, rent_date, return_date ");
		sql.append(" from t_b_status s1 ");
		sql.append(" join t_book b1  on b1.reg_no = s1.reg_no ");
		sql.append(" where rent_id = ? ");
		sql.append(" order by rent_date, reg_no ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int regNo = rs.getInt("reg_no");
				String title = rs.getString("title");
				String rentDate = rs.getString("rent_date");
				String returnDate = rs.getString("return_date");

				RentVO rent = new RentVO(regNo, title, rentDate, returnDate);

				rentList.add(rent);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rentList;
	}

	public void returnBook(RentVO rent) throws Exception {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_b_status where rent_id = ? and reg_no = ? ");
		sql.append("  ");

		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		pstmt.setString(1, rent.getRentId());
		pstmt.setInt(2, rent.getRegNo());

		pstmt.executeUpdate();

		pstmt.close();
		conn.close();

	}

}
