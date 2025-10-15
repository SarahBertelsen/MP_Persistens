package model;

public class Discount {

	private String type;
	private int amount;
	private int treshold;
	
	public Discount(String type, int amount, int treshold) {
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTreshold() {
		return treshold;
	}

	public void setTreshold(int treshold) {
		this.treshold = treshold;
	}
	
	
}
