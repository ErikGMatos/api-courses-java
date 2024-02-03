package com.br.erikmatos.courses.modules.course.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.exceptions.CourseNotFoundException;
import com.br.erikmatos.courses.modules.course.dto.UpdateCourseRequestDTO;
import com.br.erikmatos.courses.modules.course.dto.UpdateCourseResponseDTO;
import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

import lombok.NonNull;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public UpdateCourseResponseDTO execute(@NonNull UUID id, UpdateCourseRequestDTO updateCourseRequestDTO) {
        CourseEntity existingCourse = courseRepository.findById(id)
                .orElseThrow(CourseNotFoundException::new);

        existingCourse.setName(updateCourseRequestDTO.name());
        existingCourse.setCategory(updateCourseRequestDTO.category());
        existingCourse.setActive(updateCourseRequestDTO.Active());

        var savedCourse = courseRepository.save(existingCourse);
        return UpdateCourseResponseDTO.builder()
                .id(savedCourse.getId())
                .Active(savedCourse.getActive())
                .category(savedCourse.getCategory())
                .name(savedCourse.getName())
                .build();
    }

}
