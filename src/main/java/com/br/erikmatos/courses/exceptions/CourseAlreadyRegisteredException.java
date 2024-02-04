package com.br.erikmatos.courses.exceptions;

public class CourseAlreadyRegisteredException extends RuntimeException {
    public CourseAlreadyRegisteredException() {
        super("Curso já cadastrado");
    }
}
