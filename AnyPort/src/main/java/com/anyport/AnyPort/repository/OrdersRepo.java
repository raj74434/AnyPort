package com.anyport.AnyPort.repository;

import com.anyport.AnyPort.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepo  extends JpaRepository<Orders,Integer> {

    public List<Orders> findByCustomerUser(Integer id);

}
