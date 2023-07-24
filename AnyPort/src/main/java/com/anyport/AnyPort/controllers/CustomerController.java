package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.OrderDto;
import com.anyport.AnyPort.dto.PlaceOrderDTO;
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
    @GetMapping("/oldOrd/{id}")
    public ResponseEntity<List<Orders>> customerOrderhistory(@PathVariable Integer id){
        System.out.println(id);
        return new ResponseEntity<>(userService.oldOrders(id),HttpStatus.OK);
    }


    @CrossOrigin
    @PostMapping("/order/{id}")
    public ResponseEntity<Orders> createOrder(@RequestBody PlaceOrderDTO placeOrderDTO , @PathVariable Integer id){

       return new ResponseEntity<>(orderService.createOrder(placeOrderDTO,id),HttpStatus.CREATED);
    }

    @GetMapping("/getUserProfile/{userId}")
    public ResponseEntity<User>  getUserProfile(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUserProfile(userId),HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/updateProfile/{userId}")
    private ResponseEntity<User> updateProfile(@RequestBody UserDto userDto,Integer userId){

        return new ResponseEntity<>(userService.updateUserProfile(userId,userDto), HttpStatus.ACCEPTED);
    }

    @CrossOrigin
    @GetMapping("/getOrderDetails/{orderId}")
    private ResponseEntity<Orders> getOrderStatus(@PathVariable Integer orderId){

        return new ResponseEntity<>(userService.orderStatus(orderId), HttpStatus.ACCEPTED);
    }

}
