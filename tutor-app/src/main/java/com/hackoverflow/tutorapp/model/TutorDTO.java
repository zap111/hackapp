package com.hackoverflow.tutorapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@Getter
@Setter
public class TutorDTO {

    public Long id;
    public String name;
//    public AddressDTO address;
//    public String email;
//    public String description;
//    public List<Course> courses;
//    public String videoLink;
//    public Standard standard;
//    public List<Comment> comments;

}
