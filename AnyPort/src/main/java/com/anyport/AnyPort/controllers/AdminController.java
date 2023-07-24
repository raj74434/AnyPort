package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    @CrossOrigin
    @GetMapping("/allUsers")
    private ResponseEntity<List<User>> getAllUsers(){

        return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.ACCEPTED);
    }

}
