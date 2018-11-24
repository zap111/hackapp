package com.hackoverflow.tutorapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String value;
    private Integer timeOfDay;
    private Integer fees;
    private Long tutorId;
}
