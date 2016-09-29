package kr.ac.readingbetter.vo;

public class AuthorVo {

	private Long no;
	private String name;
	private String kwd2;

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

	public String getKwd2() {
		return kwd2;
	}

	public void setKwd2(String kwd2) {
		this.kwd2 = kwd2;
	}

	@Override
	public String toString() {
		return "AuthorVo [no=" + no + ", name=" + name + ", kwd2=" + kwd2 + "]";
	}
}