package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;

public class BookDAO {

	// 책 추가
	public void insertBook(BookVO book) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(reg_no, title, writer, publisher, issue_year) ");
		sql.append(" values(seq_t_book_reg_no.nextval, ?, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getIssueYear());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 전체 도서 
	public List<BookVO> selectAllBook() {

		List<BookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select b1.reg_no, b1.title, b1.writer, publisher, issue_year, case when s1.rent_no is null then '대출가능' else '대출중' end status ");
		sql.append(" from t_book b1 ");
		sql.append(" left outer join t_b_status s1      on s1.reg_no = b1.reg_no ");
		sql.append(" order by b1.title");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int regNo = rs.getInt("reg_no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int issueYear = rs.getInt("issue_Year");
				String status = rs.getString("status");
				 

				BookVO book = new BookVO(regNo, title, writer, publisher, issueYear, status);

				bookList.add(book);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

	//장서번호 체크
	public boolean noCheck(int regNo) {

		StringBuilder sql = new StringBuilder();
		sql.append("select reg_no from t_book where reg_no = ? ");
		boolean nocheck = false;

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, regNo);

			ResultSet rs = pstmt.executeQuery();

			nocheck = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nocheck;

	}

	// 도서검색 - 제목, 저자
	public List<BookVO> search(String torw, String str) {

		List<BookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select b1.reg_no, b1.title, b1.writer, publisher, issue_year, case when s1.rent_no is null then '대출가능' else '대출중' end status  ");
		sql.append(" from t_book b1 ");
		sql.append(" left outer join t_b_status s1      on s1.reg_no = b1.reg_no ");
		sql.append(" where ");
		sql.append(torw);
		sql.append(" like ? ");
		sql.append(" order by b1.title ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, "%" + str + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int regNo = rs.getInt("reg_no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int issueYear = rs.getInt("issue_Year");
				String status = rs.getString("status");

				BookVO book = new BookVO(regNo, title, writer, publisher, issueYear, status);

				bookList.add(book);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	// 도서검색 - 도서번호
	public List<BookVO> search(int regNo) {
		List<BookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select b1.reg_no, b1.title, b1.writer, publisher, issue_year, case when s1.rent_no is null then '대출가능' else '대출중' end status  ");
		sql.append(" from t_book b1 ");
		sql.append(" left outer join t_b_status s1      on s1.reg_no = b1.reg_no ");
		sql.append(" where b1.reg_no ");
		sql.append(" like ? ");
		sql.append(" order by b1.title ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, regNo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				regNo = rs.getInt("reg_no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				int issueYear = rs.getInt("issue_Year");
				String status = rs.getString("status");

				BookVO book = new BookVO(regNo, title, writer, publisher, issueYear, status);

				bookList.add(book);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}

}
