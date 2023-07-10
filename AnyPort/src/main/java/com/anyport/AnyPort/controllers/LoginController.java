package com.anyport.AnyPort.controllers;

import com.anyport.AnyPort.models.User;

import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UserRepo userRepo;

    @CrossOrigin
    @GetMapping("/signIn")
    public ResponseEntity<User> getLogin(Authentication auth){
        System.out.println(auth.getName()+"    "+auth.getCredentials());

        User u=userRepo.findByPhone(auth.getName());
        if(u !=null)return new ResponseEntity<>(u, HttpStatus.ACCEPTED);
        else throw new BadCredentialsException(("No user found with this number"));
    }
}
