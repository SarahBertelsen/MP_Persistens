package model;

import java.time.LocalDate;

public class Freight {
	private String method;
	private LocalDate deliveryDate;
	private String address;
	
	public Freight(String method, LocalDate deliveryDate, String address) {
		this.method = method;
		this.deliveryDate = deliveryDate;
		this.address = address;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
