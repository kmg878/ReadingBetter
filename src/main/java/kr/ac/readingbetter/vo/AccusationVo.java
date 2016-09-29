package kr.ac.readingbetter.vo;

public class AccusationVo {

	private Long no;
	private String reason;
	private String regDate;
	private String accept;
	private Long memberNo;
	private String id;
	private Long identity;
	private Long keyNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public Long getIdentity() {
		return identity;
	}

	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	public Long getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(Long keyNo) {
		this.keyNo = keyNo;
	}

	@Override
	public String toString() {
		return "AccusationVo [no=" + no + ", reason=" + reason + ", regDate=" + regDate + ", accept=" + accept
				+ ", memberNo=" + memberNo + ", id=" + id + ", identity=" + identity + ", keyNo=" + keyNo + "]";
	}
}