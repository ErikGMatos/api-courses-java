package com.br.erikmatos.courses.modules.course.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateCourseRequestDTO(
        @NotBlank(message = "O campo 'name' é obrigatório") String name,
        @NotBlank(message = "O campo 'category' é obrigatório") String category) {
}
