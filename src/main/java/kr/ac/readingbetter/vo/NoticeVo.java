package kr.ac.readingbetter.vo;

public class NoticeVo {

	private Long no;
	private String name;
	private String title;
	private String content;
	private String regDate;
	private Integer viewCount;
	private Long memberNo;
	private String noticePage;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getNoticePage() {
		return noticePage;
	}

	public void setNoticePage(String noticePage) {
		this.noticePage = noticePage;
	}

	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", name=" + name + ", title=" + title + ", content=" + content + ", regDate="
				+ regDate + ", viewCount=" + viewCount + ", memberNo=" + memberNo + ", noticePage=" + noticePage + "]";
	}
}