package com.hackoverflow.tutorapp.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDTO {

    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;

}
