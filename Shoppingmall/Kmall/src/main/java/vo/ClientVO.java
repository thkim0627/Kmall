package vo;

//VO(Value Object)
//자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용된다.
//대부분 DB Table별로 만들며, Table과 동일한 컬럼(필드)명을 사용한다.

//DTO(Data Transfer Object)
//Table과 무관하게 자료전달용으로만 정의한 경우 DTO라 함.

public class ClientVO {

	// 변수 선언
	private String id;
	private String password1;
	private String password2;
	private String name;
	private String address;
	private String number;
	private String email;
	
	// Setter & Getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "ClientVO [id=" + id + ", password1=" + password1 + ", password2=" + password2 + ", name=" + name
				+ ", address=" + address + ", number=" + number + ", email=" + email + "]";
	}
	
} // ClientVO