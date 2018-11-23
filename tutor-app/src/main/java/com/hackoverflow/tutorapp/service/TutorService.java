package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.entity.Tutor;
import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.model.Tutors;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    public void addTutor(TutorDTO tutorDTO) throws Exception{
        Tutor tutor = new Tutor();
        BeanUtils.copyProperties(tutorDTO, tutor);
        tutorRepository.save(tutor);
    }

//    public Tutors getTutors() throws Exception{
//        TutorDTO tutorDTO = new TutorDTO();
//        return tutorDTO.g();
//    }
}