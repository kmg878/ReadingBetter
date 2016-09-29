package kr.ac.readingbetter.vo;

public class CertificationVo {
	private Long no;
	private Long memberNo;
	private Long bookNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	@Override
	public String toString() {
		return "CertificationVo [no=" + no + ", memberNo=" + memberNo + ", bookNo=" + bookNo + "]";
	}
}