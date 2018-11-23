package com.hackoverflow.tutorapp.controller;

import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.model.Tutors;
import com.hackoverflow.tutorapp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("/tutor")
    public void addTutor(@RequestBody TutorDTO tutorDTO) throws Exception {
        tutorService.addTutor(tutorDTO);
    }

//    @GetMapping("/tutors")
//    public Tutors getTutors() throws Exception {
//        return tutorService.getTutors();
//    }
}
