package com.anyport.AnyPort.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User customerUser; // the person who is order the parcel
    @JsonIgnore
    @ManyToOne (cascade = CascadeType.ALL )
    private User driverUser;  // driver who pickup the parcel

    private Integer price;
    private String payment_method;

    private LocalDateTime orderPlacedTime;




    @OneToOne(cascade = CascadeType.ALL)
    private Address sender;   // Address where parcel have to pickup
    @OneToOne(cascade = CascadeType.ALL)
    private Address reciver;  // Address where parcel have to drop

    private String status;

    private String payment_by;

    public LocalDateTime getOrderPlacedTime() {
        return orderPlacedTime;
    }


}
