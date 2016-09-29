package kr.ac.readingbetter.vo;

public class BoardVo {

	private Long no;
	private String title;
	private String content;
	private String regDate;
	private Integer viewCount;
	private Integer groupNo;
	private String position;
	private String accept;
	private Long memberNo;
	private String id;

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

	public Integer getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(Integer groupNo) {
		this.groupNo = groupNo;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "AdminBoardVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", viewCount=" + viewCount + ", groupNo=" + groupNo + ", position=" + position + ", accept=" + accept
				+ ", memberNo=" + memberNo + ", id=" + id + "]";
	}
}