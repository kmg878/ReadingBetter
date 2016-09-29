package kr.ac.readingbetter.vo;

public class WishbookVo {
	
	private Long no;
	private String title;
	private String reason;
	private String regDate;
	private Integer recommend;
	private Integer accept;
	private Long memberNo;
	private String name;
	private String publisher;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	public Integer getAccept() {
		return accept;
	}
	public void setAccept(Integer accept) {
		this.accept = accept;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "WishbookVo [no=" + no + ", title=" + title + ", reason=" + reason + ", regDate=" + regDate
				+ ", recommend=" + recommend + ", accept=" + accept + ", memberNo=" + memberNo + ", name=" + name
				+ ", publisher=" + publisher + "]";
	}
}
