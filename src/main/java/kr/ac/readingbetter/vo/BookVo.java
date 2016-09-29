package kr.ac.readingbetter.vo;

public class BookVo {

	private Long no;
	private String title;
	private Integer recommend;
	private String cover;
	private Long publisherNo;
	private Long authorNo;
	private String authorName;
	private String publisherTitle;
	private String bkwd;
	private Integer pageNo;

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

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public Long getPublisherNo() {
		return publisherNo;
	}

	public void setPublisherNo(Long publisherNo) {
		this.publisherNo = publisherNo;
	}

	public Long getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisherTitle() {
		return publisherTitle;
	}

	public void setPublisherTitle(String publisherTitle) {
		this.publisherTitle = publisherTitle;
	}

	public String getBkwd() {
		return bkwd;
	}

	public void setBkwd(String bkwd) {
		this.bkwd = bkwd;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", recommend=" + recommend + ", cover=" + cover
				+ ", publisherNo=" + publisherNo + ", authorNo=" + authorNo + ", authorName=" + authorName
				+ ", publisherTitle=" + publisherTitle + ", bkwd=" + bkwd + ", pageNo=" + pageNo + "]";
	}
}