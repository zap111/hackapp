package com.hackoverflow.tutorapp.service;

import com.hackoverflow.tutorapp.entity.Address;
import com.hackoverflow.tutorapp.entity.Tutor;
import com.hackoverflow.tutorapp.model.AddressDTO;
import com.hackoverflow.tutorapp.model.TutorDTO;
import com.hackoverflow.tutorapp.repository.AddressRepository;
import com.hackoverflow.tutorapp.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void addTutor(TutorDTO tutorDTO) throws Exception {
        Address address = getAddress(tutorDTO);
        Tutor tutor = new Tutor();
        BeanUtils.copyProperties(tutorDTO, tutor);
        tutor.setAddressId(address.getId());
        tutorRepository.save(tutor);
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

//    public Tutors getTutors() throws Exception{
//        TutorDTO tutorDTO = new TutorDTO();
//        return tutorDTO.g();
//    }
}