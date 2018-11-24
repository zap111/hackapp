package com.hackoverflow.tutorapp.repository;

import com.hackoverflow.tutorapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
