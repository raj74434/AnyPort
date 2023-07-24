package com.anyport.AnyPort.repository;

import com.anyport.AnyPort.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
