package com.hackoverflow.tutorapp.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentDTO {
    public Long id;
    public String comment;
    public Long tutorId;
    public Long userId;
    public String username;
}
