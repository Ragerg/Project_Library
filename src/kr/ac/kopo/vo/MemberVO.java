package kr.ac.kopo.vo;

public class MemberVO {

    private String id;
    private String pw;
    private String name;
    private String address;
    private String phoneNum;

    public MemberVO() {

    }

    public MemberVO(String id, String pw, String name, String address, String phoneNum) {
        super();
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", phoneNum="
                + phoneNum + "]";
    }

}
