package model;

public class Customer {
	private String fName;
	private String lName;
	private String address;
	private String phone;
	private int zipcode;
	private int customerId;
	
	public Customer(int customerId, String fName, String lName, String address, int zipcode, String phone) {
		this.customerId = customerId;
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.zipcode = zipcode;
		this.phone = phone;
	}
	
	public String getfName() {
		return fName;
	}
	
	public void setFName(String fName) {
		this.fName = fName;
	}
	
	public void setLName(String lName) {
		this.lName = lName;
	}

	public String getlName() {
		return lName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
