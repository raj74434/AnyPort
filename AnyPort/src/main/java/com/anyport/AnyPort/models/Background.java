package com.anyport.AnyPort.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Background {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer backgroundId;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private User driverId;

    @JsonIgnore
    private LocalDate date;

    private String vehicle_type;
    private String vehicleNumber;
    private String adharcard;
    private String drivingLicenece;
    @JsonIgnore
    private boolean isVerified;


}
