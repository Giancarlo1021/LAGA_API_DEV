package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "LAGA_DRAFT_EMPLOYEES")
public class Employee extends User {
	// Password needed by the employee to add, edit, and delete rooms.
	@DynamoDBAttribute
	private String password;

}
