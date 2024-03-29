package com.br.erikmatos.courses.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.exceptions.CourseNotFoundException;
import com.br.erikmatos.courses.modules.course.dto.UpdateCourseRequestDTO;
import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, UpdateCourseRequestDTO updateCourseRequestDTO) {
        CourseEntity existingCourse = this.courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);

        existingCourse.setName(updateCourseRequestDTO.name());
        existingCourse.setCategory(updateCourseRequestDTO.category());

        return this.courseRepository.save(existingCourse);
    }

}
