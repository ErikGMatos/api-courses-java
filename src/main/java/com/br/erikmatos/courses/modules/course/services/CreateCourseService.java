package com.br.erikmatos.courses.modules.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity course) {
        return this.courseRepository.save(course);
    }
}
