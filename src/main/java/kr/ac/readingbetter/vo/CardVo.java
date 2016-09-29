package kr.ac.readingbetter.vo;

public class CardVo {
	
	private Long no; // 카드 번호
	private String title; // 카드 이름
	private String content; // 카드 내용
	private String skill; // 카드 스킬
	private Long bonus; // 카드 제공 점수
	private String cover; // 카드 커버

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

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Long getBonus() {
		return bonus;
	}

	public void setBonus(Long bonus) {
		this.bonus = bonus;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "CardVo [no=" + no + ", title=" + title + ", content=" + content + ", skill=" + skill + ", bonus="
				+ bonus + ", cover=" + cover + "]";
	}
}