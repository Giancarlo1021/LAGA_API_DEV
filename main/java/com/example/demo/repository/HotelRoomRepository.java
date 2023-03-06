package com.example.demo.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.example.demo.entity.HotelRooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class HotelRoomRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public HotelRooms save(HotelRooms hotelRooms) {
        dynamoDBMapper.save(hotelRooms);
        return hotelRooms;
    }

    public HotelRooms getHotelRoomsById(String roomNumber) {
        return dynamoDBMapper.load(HotelRooms.class, roomNumber);
    }

    public String delete(String roomNumber) {   // delete roomNumber --> all of the db entry --> customer, employee
        HotelRooms emp = dynamoDBMapper.load(HotelRooms.class, roomNumber);
        dynamoDBMapper.delete(emp);
        return "Deleted!";
    }

    public HotelRooms update(String roomNumber, HotelRooms hotelRooms) {
        dynamoDBMapper.save(hotelRooms,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("roomNumber",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(roomNumber)
                                )));
        return dynamoDBMapper.load(HotelRooms.class, roomNumber);
    }
}