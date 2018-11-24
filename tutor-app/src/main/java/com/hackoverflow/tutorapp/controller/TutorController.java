package com.hackoverflow.tutorapp.controller;

import com.hackoverflow.tutorapp.model.CommentDTO;
import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.service.SearchService;
import com.hackoverflow.tutorapp.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @Autowired
    private SearchService searchService;

    @PostMapping("/tutor")
    public Boolean addTutor(@RequestBody TutorDTO tutorDTO) throws Exception {
        tutorService.addTutor(tutorDTO);
        return Boolean.TRUE;
    }

    @GetMapping("/tutor/{id}")
    public TutorDTO getDetails(@PathVariable Long id) {
        return tutorService.getDetails(id);
    }

    @GetMapping("/tutors")
    public List<TutorDTO> getTutors() throws Exception {
        return tutorService.getTutors();
    }

    @PostMapping("/comment/add")
    public Boolean addComment(@RequestBody CommentDTO commentDTO) {
        tutorService.addComment(commentDTO);
        return Boolean.TRUE;
    }

    @GetMapping("/sentiment")
    public String getSentiment(@RequestParam String text) throws Exception {
        return tutorService.getSentiment(text);
    }
}
