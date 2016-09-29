package kr.ac.readingbetter.vo;

public class PublisherVo {
	
	private Long no;
	private String title;
	private String kwd1;

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

	public String getKwd1() {
		return kwd1;
	}

	public void setKwd1(String kwd1) {
		this.kwd1 = kwd1;
	}

	@Override
	public String toString() {
		return "PublisherVo [no=" + no + ", title=" + title + ", kwd1=" + kwd1 + "]";
	}
}