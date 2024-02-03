package com.br.erikmatos.courses.modules.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.erikmatos.courses.modules.course.entities.CourseEntity;
import com.br.erikmatos.courses.modules.course.repositories.CourseRepository;

@Service
public class ListCoursesService {

    @Autowired
    private CourseRepository companyRepository;

    public List<CourseEntity> execute() {
        var list = this.companyRepository.findAll();

        return list;
    }
}
