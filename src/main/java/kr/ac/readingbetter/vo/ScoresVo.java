package kr.ac.readingbetter.vo;

public class ScoresVo {

	private Long rank; // 순위
	private String id; // 아이디
	private String title; // 학교 이름
	private Integer monthlyScore; // 한 달 점수
	private Integer myMonthlyScore; // 로그인 한 회원의 한 달 점수
	private Integer totalScore; // 전체 점수 (초기화 되지 않는 점수)
	private Integer myTotalScore; // 로그인 한 회원의 전체 점수
	private Integer schoolScore; // 학교 점수
	private Integer mySchoolScore; // 로그인 한 회원의 학교 점수
	private Integer grade; // 학년 정보
	private Long memberNo;
	private Integer score;
	private Integer point;

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMonthlyScore() {
		return monthlyScore;
	}

	public void setMonthlyScore(Integer monthlyScore) {
		this.monthlyScore = monthlyScore;
	}

	public Integer getMyMonthlyScore() {
		return myMonthlyScore;
	}

	public void setMyMonthlyScore(Integer myMonthlyScore) {
		this.myMonthlyScore = myMonthlyScore;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Integer getMyTotalScore() {
		return myTotalScore;
	}

	public void setMyTotalScore(Integer myTotalScore) {
		this.myTotalScore = myTotalScore;
	}

	public Integer getSchoolScore() {
		return schoolScore;
	}

	public void setSchoolScore(Integer schoolScore) {
		this.schoolScore = schoolScore;
	}

	public Integer getMySchoolScore() {
		return mySchoolScore;
	}

	public void setMySchoolScore(Integer mySchoolScore) {
		this.mySchoolScore = mySchoolScore;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Long getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "ScoresVo [rank=" + rank + ", id=" + id + ", title=" + title + ", monthlyScore=" + monthlyScore
				+ ", myMonthlyScore=" + myMonthlyScore + ", totalScore=" + totalScore + ", myTotalScore=" + myTotalScore
				+ ", schoolScore=" + schoolScore + ", mySchoolScore=" + mySchoolScore + ", grade=" + grade
				+ ", memberNo=" + memberNo + ", score=" + score + ", point=" + point + "]";
	}
}