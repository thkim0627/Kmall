package criteria;

//페이징 처리
public class Criteria { 

    private int pageNum; // 현재 페이지
    private int amount; // 한 페이지에 보여줄 게시물수 
    private int skip; // 스킵 할 게시물 수 ((pageNum-1) * amount )
    
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

	@Override
	public String toString() {
		return "CriteriaVO [pageNum=" + pageNum + ", amount=" + amount + ", skip=" + skip + "]";
	}
	
} // class
