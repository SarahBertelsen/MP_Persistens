package model;

public class Customer {
	private String fName;
	private String lName;
	private String address;
	private String phone;
	private int zipcode;
	private int customerId;
	
	public Customer(int customerId, String fName, String lName, String address, int zipcode, String phone) {
		
	}
	
	private String getfName() {
		return fName;
	}
	
	private void setFName(String fName) {
		this.fName = fName;
	}
	
	private void setLName(String lName) {
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

	private int getZipcode() {
		return zipcode;
	}

	private void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	private int getCustomerId() {
		return customerId;
	}
	
	private void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
