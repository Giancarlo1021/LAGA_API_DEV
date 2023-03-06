package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@DynamoDBTable(tableName = "LAGA_DRAFT")
public class User {
	@DynamoDBAttribute
	private String firstName;
	
	@DynamoDBAttribute
	private String lastName;
	
	@DynamoDBAttribute
	private int phoneNumber;

}