package com.hackoverflow.tutorapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hackoverflow.tutorapp.enums.Standard;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TutorDTO {

    public Long id;
    public String name;
    public AddressDTO address;
    public String email;
    public String description;
    public List<CourseDTO> courses;
    public String videoLink;
    public String mobile;
    public Standard standard;
    public Integer fees;
    public List<CommentDTO> comments;

}
