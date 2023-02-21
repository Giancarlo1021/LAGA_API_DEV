package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.example.demo.controller.Customer;
import com.example.demo.controller.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "LAGA_DRAFT")
public class HotelRooms {

    @DynamoDBHashKey
    private String roomNumber;

    @DynamoDBAttribute
    private String roomName;

    @DynamoDBAttribute
    private Boolean availability;

    
    // Additions.
    @DynamoDBAttribute
    private String customerName;
    
    @DynamoDBAttribute
    private String employeeName;
    
    @DynamoDBAttribute
    private Customer customer;
   
    @DynamoDBAttribute
    private Employee employee;    
    
}