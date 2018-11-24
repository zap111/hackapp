package com.hackoverflow.tutorapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "tutor")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;
    private Integer timeOfDay;
    private Long tutorId;

    public Integer fees;

    @JsonIgnore
    @ManyToOne(targetEntity = Tutor.class)
    @JoinColumn(name = "tutorId", referencedColumnName = "id", insertable = false, updatable = false)
    private Tutor tutor;
}