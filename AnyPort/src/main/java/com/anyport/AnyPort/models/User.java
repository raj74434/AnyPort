package com.anyport.AnyPort.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userType;
    private String name;
    @Column(unique = true)
    private String phone;
    private String gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "driverId")
    @JsonIgnore
    private Background backgroundVerify;


    @OneToMany(cascade = CascadeType.ALL, mappedBy ="customerUser")
    List<Orders> order=new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy ="driverUser")
    List<Orders> driverOrders=new ArrayList<>();



    public void addOrder(Orders orders) {
       this.order.add(orders);
    }

    public void addDriverOrder(Orders orders) {
        this.driverOrders.add(orders);
    }


}
