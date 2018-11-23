package com.hackoverflow.tutorapp.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class BookingDetails {
    public Timestamp timeofbooking;
    public Long tutorId;
    public Long userId;
    public Timestamp classTime;
    public Long Id;

    public Timestamp getTimeofbooking() {
        return timeofbooking;
    }

    public void setTimeofbooking(Timestamp timeofbooking) {
        this.timeofbooking = timeofbooking;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Timestamp getClassTime() {
        return classTime;
    }

    public void setClassTime(Timestamp classTime) {
        this.classTime = classTime;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
