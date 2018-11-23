package com.hackoverflow.tutorapp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tutor {

    public Long id;
    public String name;
    public Address address;

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


    public Tutors getTutors() throws Exception{

        String json = new String(Files.readAllBytes(Paths.get("data.json")));
        Tutors tutors = OBJECT_MAPPER.readValue(json, Tutors.class);
        return tutors;

    }

    public void saveTutor(Tutor t) throws Exception{

        String json1 = new String(Files.readAllBytes(Paths.get("data.json")));
        Tutors tutors = OBJECT_MAPPER.readValue(json1, Tutors.class);
        tutors.tutors.add(t);
        String json = OBJECT_MAPPER.writeValueAsString(tutors);
        FileWriter fileWriter = new FileWriter("data.json");
        fileWriter.write(json);
        fileWriter.close();

    }


        @Override
    public String toString(){

        String s = null;
        try {
            s= OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return s;
    }

}
