package kr.ac.kopo.vo;

public class BookVO {
	
	private int regNo;
	private String title;
	private String writer;
	private String publisher;
	private int issueYear;
	private String status;
	
	public BookVO() {
		
	}

	public BookVO(int regNo, String title, String writer, String publisher, int issueYear, String status) {
		super();
		this.regNo = regNo;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.issueYear = issueYear;
		this.status = status;
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

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BookVO [regNo=" + regNo + ", title=" + title + ", writer=" + writer + ", publisher=" + publisher
				+ ", issueYear=" + issueYear + ", status=" + status + "]";
	}
	
	
	
	

	
}
