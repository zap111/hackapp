package com.hackoverflow.tutorapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long tutorId;
    public Long userId;
    public Long price;
    public Timestamp bookedFor;
    public Timestamp createdDate;
}
