package com.hackoverflow.tutorapp.entity;

import com.hackoverflow.tutorapp.enums.Standard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    //  public List<Course> courses;

    //    public List<CommentDTO> comments;
}
