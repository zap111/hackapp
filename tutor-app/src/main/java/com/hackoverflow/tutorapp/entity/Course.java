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

    private String name;
    private Integer timeOfDay;

    @JsonIgnore
    @ManyToOne(targetEntity = Tutor.class)
    @JoinColumn(name = "tutorId", referencedColumnName = "id", insertable = false, updatable = false)
    private Tutor tutor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}