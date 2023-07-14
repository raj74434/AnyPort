package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.UserRepo;
import com.anyport.AnyPort.service.OrderService;
import com.anyport.AnyPort.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @Autowired
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
    @PostMapping("/order/{id}")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders,@PathVariable Integer id){

       return new ResponseEntity<>(orderService.createOrder(orders,id),HttpStatus.CREATED);
    }



}
