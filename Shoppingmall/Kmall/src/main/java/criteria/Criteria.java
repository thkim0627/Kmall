package criteria;

import java.util.Arrays;

//페이징 처리
public class Criteria { 

	// 페이징 처리 변수
    private int pageNum; // 현재 페이지
    private int amount; // 한 페이지에 보여줄 게시물수 
    private int skip; // 스킵 할 게시물 수 ((pageNum-1) * amount )
    
    // 검색 처리 변수
    private String keyword; // 검색 키워드
    private String type; // 검색 타입
    private String[] typeArr; // 검색 타입 배열    
    
    // iv 기본값 설정 : pageNum = 1, amount = 10 
    public Criteria() {
        this(1,10);
        this.skip = 0;
    }
    
    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
        this.skip = (pageNum-1)*amount;
    }

    // Getter & Setter
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.skip = (pageNum-1)*this.amount;
		this.pageNum = pageNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.skip = (this.pageNum-1)*amount;
		this.amount = amount;
	}

	public int getSkip() {
		return skip;
	}

	public void setSkip(int skip) {
		this.skip = skip;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		// type을 배열로 변환하기 위해서 String타입의 데이터를 String배열타입 데이터로 변환해주는 split() 메서드를 사용.
		this.typeArr = type.split("");
	}

	public String[] getTypeArr() {
		return typeArr;
	}

	public void setTypeArr(String[] typeArr) {
		this.typeArr = typeArr;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + ", keyword=" + keyword
				+ ", type=" + type + ", typeArr=" + Arrays.toString(typeArr) + "]";
	}
		
} // class