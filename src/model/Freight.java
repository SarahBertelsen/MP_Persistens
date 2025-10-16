package model;

import java.time.LocalDate;

public class Freight {
	private String method;
	private LocalDate deliveryDate;
	private String address;
	private int freightId;

	public Freight(int freightId, String method, LocalDate deliveryDate, String address) {
		this.freightId = freightId;
		this.method = method;
		this.deliveryDate = deliveryDate;
		this.address = address;
	}

	public int getFreightId() {
		return freightId;
	}

	public void setFreightId(int freightId) {
		this.freightId = freightId;
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
