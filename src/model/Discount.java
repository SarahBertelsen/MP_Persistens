package model;

public class Discount {
	private int discountId;
	private String type;
	private double amount;
	private double treshold;
	
	public Discount(int discountId, String type, double amount, double treshold) {
		this.setDiscountId(discountId);
		this.type = type;
		this.amount = amount;
		this.treshold = treshold;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTreshold() {
		return treshold;
	}

	public void setTreshold(int treshold) {
		this.treshold = treshold;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	
	
}
