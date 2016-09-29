package kr.ac.readingbetter.vo;

public class CommentsVo {

	private Long no;
	private String content;
	private String regDate;
	private String state;
	private Long noticeNo;
	private Long memberNo;
	private String id;
	private String commentsPage;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(Long noticeNo) {
		this.noticeNo = noticeNo;
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

	public String getCommentsPage() {
		return commentsPage;
	}

	public void setCommentsPage(String commentsPage) {
		this.commentsPage = commentsPage;
	}

	@Override
	public String toString() {
		return "CommentsVo [no=" + no + ", content=" + content + ", regDate=" + regDate + ", state=" + state
				+ ", noticeNo=" + noticeNo + ", memberNo=" + memberNo + ", id=" + id + ", commentsPage=" + commentsPage
				+ "]";
	}
}