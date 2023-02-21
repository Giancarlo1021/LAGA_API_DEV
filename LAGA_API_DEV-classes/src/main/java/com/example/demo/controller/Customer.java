package com.example.demo.controller;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends User {
	@DynamoDBAttribute
	private String email;
	
	@DynamoDBAttribute
	private String creditCardNumber;

}
