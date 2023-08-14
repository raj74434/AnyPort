package com.anyport.AnyPort.service;

import com.anyport.AnyPort.dto.DistanceDTO;
import com.anyport.AnyPort.dto.UserDto;
import com.anyport.AnyPort.mappingInfo.MappingInfo;
import com.anyport.AnyPort.models.Orders;
import com.anyport.AnyPort.models.User;
import com.anyport.AnyPort.repository.OrdersRepo;
import com.anyport.AnyPort.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MappingInfo mapper;
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private User userEntity;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createCustomerUser(UserDto userDto){
        User user=mapper.userDto_to_user(userDto);
        user.setUserType("ROLE_CUSTOMER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepo.save(user);

    }

    @Override
    public List<Orders> oldOrders(Integer id){
        System.out.println("Oder details");
        List<Orders> orders=ordersRepo.findByCustomerUser(id);
        return orders;
    }

//    By this we are setting order details of Rider User
    @Override
    public User getUserProfile(Integer id){
       User user= userRepo.findById(id).orElseThrow();
       if(user.getUserType().equals("ROLE_RIDER")){
           user.setOrder(user.getDriverOrders());
       }
       return user;
    }

    @Override
    public User updateUserProfile(Integer id,UserDto userDto){
        User user= userRepo.findById(id).orElseThrow();
        if( !userDto.getGender().equals(user.getGender() )&& !userDto.getGender().equals("") ) user.setGender(userDto.getGender());
        if(!userDto.getName() .equals("")){user.setName(userDto.getName());}
        if(!userDto.getPhone().equals("")){user.setPhone(user.getPhone());}
        if(!userDto.getPassword().equals("")){user.setPassword(passwordEncoder.encode(userDto.getPassword())); }

        return userRepo.save(user);
    }

    @Override
    public Orders orderStatus(Integer orderId){

        Orders orders=ordersRepo.findById(orderId).orElseThrow(()-> new RuntimeException());
        return orders;
    }


//    Calculate distance in 2 locations

        // Radius of the Earth in kilometers
        private static final double EARTH_RADIUS_KM = 6371.0;
    @Override
        public DistanceDTO calculateDistance(DistanceDTO distanceDTO) {
            // Convert latitude and longitude from degrees to radians
            double radLat1 = Math.toRadians(distanceDTO.getSenderLatitude());
            double radLon1 = Math.toRadians(distanceDTO.getSenderLongitude());
            double radLat2 = Math.toRadians(distanceDTO.getReciverLatitude());
            double radLon2 = Math.toRadians(distanceDTO.getReciverLongitude());

            // Haversine formula
            double dLat = radLat2 - radLat1;
            double dLon = radLon2 - radLon1;
            double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(dLon / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = EARTH_RADIUS_KM * c;
            distanceDTO.setPrice((int)distance*2*10);

            return distanceDTO;
        }





}
