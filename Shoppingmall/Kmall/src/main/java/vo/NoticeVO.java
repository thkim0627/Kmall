package vo;

public class NoticeVO {
	
	// 변수 선언
    private int seq;
    private String title;
    private String id; 
    private String content;
    private String regdate;
    private int cnt;

    // Setter & Getter
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "NoticeVO [seq=" + seq + ", title=" + title + ", id=" + id + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
    
    
} // class