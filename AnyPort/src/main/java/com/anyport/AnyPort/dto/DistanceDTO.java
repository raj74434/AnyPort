package com.anyport.AnyPort.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DistanceDTO {

    private Double senderLongitude;

    private Double senderLatitude;

    private Double reciverLongitude;

    private Double reciverLatitude;

    @JsonProperty( access =JsonProperty.Access.READ_ONLY)
    private Integer price;

}
