package com.app.gestiontareas.domain.port.output;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    TaskResponseDto save(Task task);
    Optional<TaskResponseDto> findById(UUID id);

    List<TaskResponseDto> findAll();
    void deleteById(UUID id);
}
