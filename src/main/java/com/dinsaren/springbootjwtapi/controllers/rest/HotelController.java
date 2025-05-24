package com.dinsaren.springbootjwtapi.controllers.rest;

import com.dinsaren.springbootjwtapi.constants.Constants;
import com.dinsaren.springbootjwtapi.exception.AppException;
import com.dinsaren.springbootjwtapi.models.Category;
import com.dinsaren.springbootjwtapi.models.Floor;
import com.dinsaren.springbootjwtapi.models.Hotel;
import com.dinsaren.springbootjwtapi.models.Room;
import com.dinsaren.springbootjwtapi.models.req.BasePostReq;
import com.dinsaren.springbootjwtapi.models.res.MessageRes;
import com.dinsaren.springbootjwtapi.repository.FloorRepository;
import com.dinsaren.springbootjwtapi.repository.HotelRepository;
import com.dinsaren.springbootjwtapi.repository.RoomRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/hotels")
@Slf4j
public class HotelController {
  private final HotelRepository hotelRepository;
  private final FloorRepository floorRepository;
  private final RoomRepository roomRepository;
  private MessageRes messageRes;
  public HotelController(HotelRepository hotelRepository, FloorRepository floorRepository,
      RoomRepository roomRepository) {
    this.hotelRepository = hotelRepository;
    this.floorRepository = floorRepository;
    this.roomRepository = roomRepository;
  }

  @PostMapping("/list")
  public ResponseEntity<Object> getAll(@RequestBody BasePostReq req) {
    messageRes = new MessageRes();
    try {
      log.info("Intercept get all hotel req {}", req);
      List<Hotel> hotelList = hotelRepository.findAllByStatusOrderByIdDesc(Constants.STATUS_ACTIVE);
      messageRes = new MessageRes();
      messageRes.setSuccess(hotelList);
      return new ResponseEntity<>(messageRes, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error internal error get all hotel {}", e.toString());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/getById/{id}")
  public ResponseEntity<Object> getHotelById(@RequestBody BasePostReq req, @PathVariable("id") Integer id) {
    messageRes = new MessageRes();
    try {
      log.info("Intercept get hotel by id {} req {}",id, req);
      Hotel hotel = hotelRepository.findByIdAndStatus(id,Constants.STATUS_ACTIVE);
      List<Floor> floorList = floorRepository.findAllByHotelIdAndStatus(hotel.getId(), Constants.STATUS_ACTIVE);
      if(!floorList.isEmpty()){
        List<Floor> floors = new ArrayList<>();
        for (Floor floor : floorList) {
          List<Room> rooms = roomRepository.findAllByFloorIdAndStatus(floor.getId(), Constants.STATUS_ACTIVE);
          if (!rooms.isEmpty()) {
            floor.setRooms(rooms);
          }
          floors.add(floor);
        }
        hotel.setFloors(floors);
      }
      messageRes = new MessageRes();
      messageRes.setSuccess(hotel);
      return new ResponseEntity<>(messageRes, HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error internal error get hotel by id {}", e.toString());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
