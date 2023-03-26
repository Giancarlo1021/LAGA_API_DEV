package Entities;

public class HotelRoom {
	private String room;
	
	private int roomNumber;
	
	private boolean status;
	
	//private String customerName;
	
	
	public boolean checkAvailability() {
		return status;
	}
	
	public String getRoomName() {
		return room;
	}
	
	public void setRoomName(String room) {
		this.room = room;
	}
	
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public boolean getAvailability() {
		return status;
	}
	
	public void setAvailability(boolean status) {
		this.status = status;
	}
	
	/*
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	*/
}
