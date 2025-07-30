package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;

import java.util.UUID;

public class CreateTaskUseCase {
    private final TaskRepository taskRepository;

    public CreateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public TaskResponseDto createTask(String title) {
        Task createdTask = new Task(UUID.randomUUID(),title, false);
        return taskRepository.save(createdTask);
    }
}
