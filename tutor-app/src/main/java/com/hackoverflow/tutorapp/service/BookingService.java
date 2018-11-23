package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.entity.Booking;
import com.hackoverflow.tutorapp.model.BookingDTO;
import com.hackoverflow.tutorapp.repository.BookingRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void bookTutorial(BookingDTO bookingDTO){
        Booking booking = new Booking();
        BeanUtils.copyProperties(bookingDTO, booking);
        bookingRepository.save(booking);
    }
}
