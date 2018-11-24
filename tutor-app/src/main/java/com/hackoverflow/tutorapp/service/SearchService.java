package com.hackoverflow.tutorapp.service;


import com.hackoverflow.tutorapp.entity.Tutor;
import com.hackoverflow.tutorapp.repository.CourseRepository;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static List<Tutor> getResult(String searchString) throws Exception {

        List<String> search = new LocationFn().getPOSModel(searchString);
    }

    public static void main(String[] args) throws Exception {
        getResult("gachibowli tutors physics");

    }

}
