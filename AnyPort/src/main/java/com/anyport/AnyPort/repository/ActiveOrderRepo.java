package com.anyport.AnyPort.repository;

import com.anyport.AnyPort.models.ActiveOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveOrderRepo extends JpaRepository<ActiveOrders,Integer> {
}
