package kr.ac.kopo.vo;

public class BookVO {
	
	private int regNo;
	private String title;
	private String writer;
	private String publisher;
	private String issueYear;
	private int stock;
	
	public BookVO() {
		
	}

	public BookVO(int regNo, String title, String writer, String publisher, String issueYear, int stock) {
		super();
		this.regNo = regNo;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.issueYear = issueYear;
		this.stock = stock;
	}

	public int getRegNo() {
		return regNo;
	}

	public void setRegNo(int regNo) {
		this.regNo = regNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(String issueYear) {
		this.issueYear = issueYear;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "BookVO [regNo=" + regNo + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", issueYear=" + issueYear + ", stock=" + stock + "]";
	}

	
}
