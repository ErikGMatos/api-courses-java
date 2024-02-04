package com.br.erikmatos.courses.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.exceptions.CourseNotFoundException;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID id) {
        if (this.courseRepository.existsById(id)) {
            this.courseRepository.deleteById(id);
        } else {
            throw new CourseNotFoundException();
        }
    }
}
