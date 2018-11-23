package com.hackoverflow.tutorapp.controller;

import com.hackoverflow.tutorapp.model.BookingDTO;
import com.hackoverflow.tutorapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/tutorial/book")
    public Boolean bookTutorial(@RequestBody BookingDTO bookingDTO) {
        bookingService.bookTutorial(bookingDTO);
        return Boolean.TRUE;
    }
}
