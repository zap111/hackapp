package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.repository.CourseRepository;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static void getResult(String searchString) throws Exception {
        LocationFn.find(searchString);
    }

    public static void main(String[] args) throws Exception {
        getResult("physics tutors in Hyderabad");
    }

}
