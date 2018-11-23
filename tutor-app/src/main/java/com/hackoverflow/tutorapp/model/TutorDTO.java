package com.hackoverflow.tutorapp.model;

import com.hackoverflow.tutorapp.enums.Standard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TutorDTO {

    public Long id;
    public String name;
    public AddressDTO address;
    public String email;
    public String description;
    public List<CourseDTO> courses;
    public String videoLink;
    public Standard standard;
    public List<CommentDTO> comments;

}
