package com.anyport.AnyPort.service;


import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {

        System.out.println(phone +" userdetail service" );
        User opt= userRepo.findByPhone(phone);

        if(opt!=null) {

            User customer= opt;

            List<GrantedAuthority> authorities= new ArrayList<>();
            //authorities.add(new SimpleGrantedAuthority(customer.getRole()));


            return new org.springframework.security.core.userdetails.User(customer.getPhone(), customer.getPassword(), authorities);



        }else
            throw new BadCredentialsException("User Details not found with this phone");


    }
}
