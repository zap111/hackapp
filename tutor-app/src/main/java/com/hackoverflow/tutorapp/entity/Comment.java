package com.hackoverflow.tutorapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String comment;
    public Long tutorId;
    public Long userId;
    public String user;
    public String sentiment;

    @JsonIgnore
    @ManyToOne(targetEntity = Tutor.class)
    @JoinColumn(name = "tutorId", referencedColumnName = "id", insertable = false, updatable = false)
    public Tutor tutor;
}
