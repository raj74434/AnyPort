package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.DistanceDTO;
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


@Controller
@RequestMapping("/customer")
public class CustomerController {



    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;


    @PostMapping("/signup")
    private ResponseEntity<User> Signup(@RequestBody UserDto userDto){
        System.out.println(userDto);
        return new ResponseEntity<>(userService.createCustomerUser(userDto), HttpStatus.CREATED);
    }



    @GetMapping("/all/oldOrd/{id}")
    public ResponseEntity<List<Orders>> customerOrderhistory(@PathVariable Integer id){
        System.out.println(id);
        return new ResponseEntity<>(userService.oldOrders(id),HttpStatus.OK);
    }



    @PostMapping("/all/order/{id}")
    public ResponseEntity<Orders> createOrder(@RequestBody PlaceOrderDTO placeOrderDTO , @PathVariable Integer id){

       return new ResponseEntity<>(orderService.createOrder(placeOrderDTO,id),HttpStatus.CREATED);
    }

    @GetMapping("/all/getUserProfile/{userId}")
    public ResponseEntity<User>  getUserProfile(@PathVariable Integer userId){
        return new ResponseEntity<>(userService.getUserProfile(userId),HttpStatus.OK);
    }


    @PutMapping("/all/updateProfile/{userId}")
    private ResponseEntity<User> updateProfile(@RequestBody UserDto userDto,Integer userId){

        return new ResponseEntity<>(userService.updateUserProfile(userId,userDto), HttpStatus.ACCEPTED);
    }


    @GetMapping("/all/getOrderDetails/{orderId}")
    private ResponseEntity<Orders> getOrderStatus(@PathVariable Integer orderId){

        return new ResponseEntity<>(userService.orderStatus(orderId), HttpStatus.ACCEPTED);
    }


    @GetMapping("/calculatePrice")
    private ResponseEntity<DistanceDTO> calculatePrice(@RequestBody DistanceDTO distanceDTO){

        return new ResponseEntity<>(
                userService.calculateDistance(distanceDTO)
                , HttpStatus.ACCEPTED);
    }



}
