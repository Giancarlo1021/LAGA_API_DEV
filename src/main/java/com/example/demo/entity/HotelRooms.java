package com.example.demo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
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

}