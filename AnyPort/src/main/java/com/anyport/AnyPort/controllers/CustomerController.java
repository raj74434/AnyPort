package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.service.OrderService;
import com.anyport.AnyPort.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private UserService userService;

    private OrderService orderService;

    @CrossOrigin
    @PostMapping("/signup")
    private ResponseEntity<User> Signup(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return new ResponseEntity<>(userService.createCustomerUser(userDto), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping("/check")
    private ResponseEntity<String> check(){
        System.out.println("Recevied");
       return new ResponseEntity<>("it is ok",HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/oldOrd/{id}")
    public ResponseEntity<List<Orders>> customerOrderhistory(@PathVariable Integer id){
        return new ResponseEntity<>(userService.oldOrders(id),HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/order")
    public ResponseEntity<Orders> createOrder(OrderDto orderDto){
       return new ResponseEntity<>(orderService.createOrder(orderDto),HttpStatus.CREATED);
    }



}
