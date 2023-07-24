package com.anyport.AnyPort.service;

import com.anyport.AnyPort.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {
    List<User> getAllUsers();
}
