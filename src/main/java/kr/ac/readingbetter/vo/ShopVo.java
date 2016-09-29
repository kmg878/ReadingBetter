package kr.ac.readingbetter.vo;

public class ShopVo {
	
	private Long no; // 상품 번호
	private String title; // 상품명
	private Long price; // 상품 가격(캔디)
	private String cover; // 상품 사진

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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "ShopVo [no=" + no + ", title=" + title + ", price=" + price + ", cover=" + cover + "]";
	}
}