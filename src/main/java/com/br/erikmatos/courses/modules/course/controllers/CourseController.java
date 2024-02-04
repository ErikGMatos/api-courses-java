package com.br.erikmatos.courses.modules.course.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.erikmatos.courses.modules.course.dto.PatchCourseActiveRequestDTO;
import com.br.erikmatos.courses.modules.course.dto.UpdateCourseRequestDTO;
import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.services.CreateCourseService;
import com.br.erikmatos.courses.modules.course.services.DeleteCourseService;
import com.br.erikmatos.courses.modules.course.services.ListCoursesService;
import com.br.erikmatos.courses.modules.course.services.PatchCourseService;
import com.br.erikmatos.courses.modules.course.services.UpdateCourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class CourseController {

    @Autowired
    private CreateCourseService createCourseService;

    @Autowired
    private ListCoursesService listCoursesService;

    @Autowired
    private UpdateCourseService updateCourseService;

    @Autowired
    private DeleteCourseService deleteCourseService;

    @Autowired
    private PatchCourseService patchCourseService;

    @GetMapping("/cursos")
    public ResponseEntity<Object> listAllCourses() {
        try {
            var listCourses = this.listCoursesService.execute();
            return ResponseEntity.ok().body(listCourses);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/cursos")
    public ResponseEntity<Object> createCourse(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var createdCourse = this.createCourseService.execute(courseEntity);
            return ResponseEntity.ok().body(createdCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable UUID id,
            @Valid @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO) {
        try {
            var createdCourse = this.updateCourseService.execute(id, updateCourseRequestDTO);
            return ResponseEntity.ok().body(createdCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable UUID id) {
        try {
            this.deleteCourseService.execute(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/cursos/{id}/active")
    public ResponseEntity<Object> patchCourse(@PathVariable UUID id,
            @Valid @RequestBody PatchCourseActiveRequestDTO status) {
        try {
            var updatedCourse = this.patchCourseService.execute(id, status.getActive());
            return ResponseEntity.ok().body(updatedCourse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
