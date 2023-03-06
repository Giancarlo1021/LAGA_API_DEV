package com.example.demo.controller;

import com.example.demo.entity.HotelRooms;
import com.example.demo.repository.HotelRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController {

    @Autowired
    private HotelRoomRepository hotelRoomRepository;

    @PostMapping("/room")
    public HotelRooms saveHotelRooms(@RequestBody HotelRooms hotelRooms) {
        return hotelRoomRepository.save(hotelRooms);
    }

    @GetMapping("/room/{id}")
    public HotelRooms getHotelRooms(@PathVariable("id") String roomNumber) {
        return hotelRoomRepository.getHotelRoomsById(roomNumber);
    }

    @DeleteMapping("/room/{id}")
    public String deleteEmployee (@PathVariable("id") String roomNumber) {
        return hotelRoomRepository.delete(roomNumber);
    }

    @PutMapping("/room/{id}")
    public HotelRooms updateEmployee(@PathVariable("id") String roomNumber, @RequestBody HotelRooms hotelRooms){
       return hotelRoomRepository.update(roomNumber, hotelRooms);
    }
}
