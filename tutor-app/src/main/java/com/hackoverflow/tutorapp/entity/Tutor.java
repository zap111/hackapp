package com.hackoverflow.tutorapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.hackoverflow.tutorapp.enums.Standard;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
@ToString(doNotUseGetters = true, exclude = "courses")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "address_id")
    public Long addressId;

    @Column(name = "email")
    public String email;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "description")
    public String description;

    @Column(name = "link")
    public String videoLink;

    @Column(name = "standard")
    @Enumerated(value = EnumType.STRING)
    public Standard standard;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", insertable = false, updatable = false)
    public Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "tutor")
    public List<Course> courses;

    @JsonIgnore
    @OneToMany(mappedBy = "tutor")
    public List<Comment> comments;
}
