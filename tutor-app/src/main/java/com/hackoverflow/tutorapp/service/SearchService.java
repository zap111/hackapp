package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.entity.Course;

import com.hackoverflow.tutorapp.entity.Address;
import com.hackoverflow.tutorapp.entity.Tutor;
import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.repository.AddressRepository;
import com.hackoverflow.tutorapp.repository.CourseRepository;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class SearchService {
    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<Tutor> getSearchResult(String searchString) throws Exception {

        List<TutorDTO> tutorsDto = new ArrayList<>();

        List<String> search = new LocationFn().getPOSModel(searchString);
        StringBuilder reg = new StringBuilder();//StringUtils.join(search,'|');

        for (int i=0;i<=search.size()-1;i++) {
            reg.append(".*"+search.get(i));
            if (i!=search.size()-1)
                reg.append(".*|");
        }

        //remove course and address repo
        List<Course> courses = courseRepository.findAll();
        courses.stream().filter(x->x.getValue().matches(reg.toString()));
        List<Address> addresses = addressRepository.findAll();
        addresses.stream().filter(x->x.getAddress().matches(reg.toString()));

        List<Tutor> tutors = tutorRepository.findAll();
        tutors.stream().filter(x->x.address.getAddress().matches(reg.toString()) ||
                x.courses.stream().filter(y->y.getValue().matches(reg.toString())).collect(Collectors.toList()).size()>0).collect(Collectors.toList());



        return tutors;
    }

    public static void main(String[] args) throws Exception {
        //getResult("gachibowli tutors physics");

    }

}
