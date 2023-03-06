package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "LAGA_DRAFT_CUSTOMERS")
public class Customer extends User {
	@DynamoDBAttribute
	private int roomNumber;
	
	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String creditCardNumber;

}
