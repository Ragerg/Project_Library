package kr.ac.kopo.vo;

public class RentVO {

    private int rentNo;
    private int regNo;
    private String title;
    private String rentId;
    private String rentDate;
    private String returnDate;

    public RentVO() {
    }

    public RentVO(int rentNo, int regNo, String title, String rentId, String rentDate, String returnDate) {
        super();
        this.rentNo = rentNo;
        this.regNo = regNo;
        this.title = title;
        this.rentId = rentId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public RentVO(int regNo, String title, String rentDate, String returnDate) {
        super();
        this.regNo = regNo;
        this.title = title;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    public int getRentNo() {
        return rentNo;
    }

    public void setRentNo(int rentNo) {
        this.rentNo = rentNo;
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

    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "RentVO [rentNo=" + rentNo + ", regNo=" + regNo + ", title=" + title + ",  rentId=" + rentId
                + ", rentDate=" + rentDate + ", returnDate=" + returnDate + "]";
    }

}
