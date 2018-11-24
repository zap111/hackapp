package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.entity.Address;
import com.hackoverflow.tutorapp.entity.Comment;
import com.hackoverflow.tutorapp.entity.Course;
import com.hackoverflow.tutorapp.entity.Tutor;
import com.hackoverflow.tutorapp.model.AddressDTO;
import com.hackoverflow.tutorapp.model.CommentDTO;
import com.hackoverflow.tutorapp.model.CourseDTO;
import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.repository.AddressRepository;
import com.hackoverflow.tutorapp.repository.CommentRepository;
import com.hackoverflow.tutorapp.repository.CourseRepository;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeroturnaround.exec.ProcessExecutor;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public void addTutor(TutorDTO tutorDTO) throws Exception {
        Address address = getAddress(tutorDTO);
        Tutor tutor = new Tutor();
        BeanUtils.copyProperties(tutorDTO, tutor);
        tutor.setAddressId(address.getId());
        tutorRepository.save(tutor);
        tutorDTO.setId(tutor.getId());
        saveCourses(tutorDTO);
    }

    private void saveCourses(TutorDTO tutorDTO) {
        List<Course> courses = new ArrayList<>();
        List<CourseDTO> courseDTOS = tutorDTO.getCourses();
        courseDTOS.forEach(courseDTO -> {
            Course course = new Course();
            BeanUtils.copyProperties(courseDTO, course);
            course.setTutorId(tutorDTO.getId());
            courses.add(course);
        });
        courseRepository.save(courses);
    }

    private Address getAddress(TutorDTO tutorDTO) {
        AddressDTO addressDTO = tutorDTO.getAddress();
        Address address = new Address();
        BeanUtils.copyProperties(addressDTO, address);
        return addressRepository.save(address);
    }

    public TutorDTO getDetails(Long id) {
        Tutor tutor = tutorRepository.findOne(id);
        TutorDTO tutorDTO = new TutorDTO();
        if (tutor != null) {
            BeanUtils.copyProperties(tutor, tutorDTO);
            Address address = tutor.getAddress();
            AddressDTO addressDTO = new AddressDTO();
            BeanUtils.copyProperties(address, addressDTO);
            tutorDTO.setAddress(addressDTO);
        }
        return tutorDTO;
    }

    public List<TutorDTO> getTutors() throws Exception {
        List<TutorDTO> tutorDTOS = new ArrayList<>();
        List<Tutor> tutors = tutorRepository.findAll();
        tutors.forEach(tutor -> {
            TutorDTO tutorDTO = new TutorDTO();
            BeanUtils.copyProperties(tutor, tutorDTO);
            Address address = tutor.getAddress();
            AddressDTO addressDTO = new AddressDTO();
            BeanUtils.copyProperties(address, addressDTO);
            tutorDTO.setAddress(addressDTO);
            tutorDTOS.add(tutorDTO);
        });
        return tutorDTOS;
    }

    public void addComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDTO, comment);
        commentRepository.save(comment);
    }

    public String getSentiment(String comment) throws InterruptedException, TimeoutException, IOException {
        return new ProcessExecutor().command("/anaconda3/bin/python", "src/sentiment.py", comment)
                .readOutput(true).execute().outputUTF8();
    }
}