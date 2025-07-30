package com.app.gestiontareas.infrastructure.controllers.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class TaskResponseDto {
    private UUID id;
    private String title;
    private boolean completed;
}
