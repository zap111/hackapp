package com.hackoverflow.tutorapp.controller;

import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping("/tutor")
    public Boolean addTutor(@RequestBody TutorDTO tutorDTO) throws Exception {
        tutorService.addTutor(tutorDTO);
        return Boolean.TRUE;
    }

    @GetMapping("/tutor/{id}")
    public TutorDTO getDetails(@PathVariable Long id) {
        return tutorService.getDetails(id);
    }

//    @GetMapping("/tutors")
//    public Tutors getTutors() throws Exception {
//        return tutorService.getTutors();
//    }
}
