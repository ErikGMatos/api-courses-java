package com.br.erikmatos.courses.modules.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.services.CreateCourseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CreateCourseService createCourseService;

    @GetMapping("/all")
    public ResponseEntity<String> listAllCourses() {
        return ResponseEntity.ok().body("Esse é o list");
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCourse(@RequestBody CourseEntity courseEntity) {
        try {
            return ResponseEntity.ok().body("Esse é o create");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
