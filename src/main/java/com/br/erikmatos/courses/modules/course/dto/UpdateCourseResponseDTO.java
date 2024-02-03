package com.br.erikmatos.courses.modules.course.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseResponseDTO {
    private UUID id;
    private String name;
    private String category;
    private String Active;
}
