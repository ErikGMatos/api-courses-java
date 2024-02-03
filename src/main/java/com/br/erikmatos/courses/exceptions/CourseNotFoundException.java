package com.br.erikmatos.courses.exceptions;

public class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException() {
        super("Curso não foi encontrado");
    }
}
