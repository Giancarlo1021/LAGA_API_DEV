package Entities;


public class User {

	private String firstName;
	
	private String lastName;
	
	private int phoneNumber;
	
	private String email;
	
	private String address;
	
	
	public String getFirstName() {
		return firstName;
	}

	/*
	 * <p> this is a sample java doc aaaaaa <p>
	 * 
	 * @param firstName its a firstName
	 * 
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}