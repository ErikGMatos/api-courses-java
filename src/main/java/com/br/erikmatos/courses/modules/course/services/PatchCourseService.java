package com.br.erikmatos.courses.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.exceptions.CourseNotFoundException;
import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.entities.StatusEnum;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class PatchCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, StatusEnum status) {
        CourseEntity existingCourse = courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);

        existingCourse.setActive(status);

        return this.courseRepository.save(existingCourse);
    }
}
