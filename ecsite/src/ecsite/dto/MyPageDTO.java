package ecsite.dto;

public class MyPageDTO {

	private String buyItemName;
	private int buyTotalPrice;
	private int buyTotalCount;
	private String payment;
	private String insertDate;


	public String getBuyItemName() {
		return buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}

	public int getBuyTotalPrice() {
		return buyTotalPrice;
	}
	public void setBuyTotalPrice(int buyTotalPrice) {
		this.buyTotalPrice = buyTotalPrice;
	}

	public int getBuyTotalCount() {
		return buyTotalCount;
	}
	public void setBuyTotalCount(int buyTotalCount) {
		this.buyTotalCount = buyTotalCount;
	}

	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
