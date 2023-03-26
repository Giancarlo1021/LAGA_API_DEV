package Entities;

import java.util.ArrayList;

public class Customer extends User {
	public Customer() {
		
	}
	
	//private int roomNumber;
	//private ArrayList<Integer> roomNumbers;

	private int creditCardNumber;
	
	/*
	public ArrayList<Integer> getRoomNumbers() {
		return roomNumbers;
	}

	public void setRoomNumbers(ArrayList<Integer> roomNumbers) {
		this.roomNumbers = roomNumbers;
	}
	*/

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
}
