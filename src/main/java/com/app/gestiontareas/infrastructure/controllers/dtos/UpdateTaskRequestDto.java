package com.app.gestiontareas.infrastructure.controllers.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UpdateTaskRequestDto {
    @NotBlank
    private UUID id;
    @NotBlank
    @Size(min = 1, max = 100)
    private String title;
    @NotBlank
    private boolean completed;
}
