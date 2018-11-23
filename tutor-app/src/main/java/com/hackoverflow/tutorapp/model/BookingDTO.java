package com.hackoverflow.tutorapp.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BookingDTO {

    public Long id;
    public Long tutorId;
    public Long userId;
    public Long price;
    public Timestamp time;
    public Timestamp createdDate;

}
