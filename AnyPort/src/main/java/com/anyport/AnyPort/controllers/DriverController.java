package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.ActiveOrders;
import com.anyport.AnyPort.models.Background;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/drive")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @CrossOrigin
    @PostMapping("/createNewDriver")
    public ResponseEntity<User> createDriverUser(@RequestBody  UserDto userDto) {
      return new ResponseEntity<>(driverService.createDriverUser(userDto),HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("/verifyBackground/{userId}")
    public ResponseEntity<Background> verifyBackground(@RequestBody  Background background ,Integer userId) {
        return new ResponseEntity<>(driverService.veryfyBackground(background,userId),HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/activeOrders")
    public ResponseEntity<List<ActiveOrders>> getAllActiveOrders(){
        return new ResponseEntity<>(driverService.getAllActiveOrders(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/catchOrder")
    public ResponseEntity<List<Orders>> catchOrder(Integer orderId,Integer userId){
        return new ResponseEntity<>(driverService.catchOrder(orderId,userId), HttpStatus.OK);
    }

}
