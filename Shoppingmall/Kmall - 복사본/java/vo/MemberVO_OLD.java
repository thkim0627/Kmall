package vo;

//** VO (Value Object) , DTO (Data Transfer Object)
//=> 자료의 구조를 표현하는 클래스이며, 자료의 전달에 이용됨
//=> 대부분 Table 별로 만들며, Table 과 동일한 필드(컬럼)명을 사용한다.
//=> Table과 무관하게 자료전달용으로만 정의한 경우 DTO라 함.

public class MemberVO_OLD {
	
	private String id;
	private String password;
	private String name;
	private String lev;
	private String birthd;
	private int point;
	private double weight;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public String getBirthd() {
		return birthd;
	}
	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", lev=" + lev + ", birthd="
				+ birthd + ", point=" + point + ", weight=" + weight + "]";
	}
} //class
