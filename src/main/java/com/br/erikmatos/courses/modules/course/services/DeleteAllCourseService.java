package com.br.erikmatos.courses.modules.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class DeleteAllCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void execute() {
        this.courseRepository.deleteAll();
    }
}
