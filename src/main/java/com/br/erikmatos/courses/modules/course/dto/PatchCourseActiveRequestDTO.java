package com.br.erikmatos.courses.modules.course.dto;

import com.br.erikmatos.courses.modules.course.entities.StatusEnum;

import lombok.Data;

@Data
public class PatchCourseActiveRequestDTO {

    private StatusEnum active;
}
