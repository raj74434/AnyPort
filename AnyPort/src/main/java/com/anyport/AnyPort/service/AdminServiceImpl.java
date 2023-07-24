package com.anyport.AnyPort.service;

import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

}
