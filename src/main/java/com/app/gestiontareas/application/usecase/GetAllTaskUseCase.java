package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;

import java.util.List;

public class GetAllTaskUseCase {
    private final TaskRepository taskRepository;

    public GetAllTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll();
    }
}
