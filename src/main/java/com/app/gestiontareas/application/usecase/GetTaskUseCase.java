package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.exception.TaskNotFoundException;
import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;


import java.util.UUID;

public class GetTaskUseCase {
    private final TaskRepository taskRepository;

    public GetTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Task findTaskById(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(() ->
                new TaskNotFoundException(id));
        return task;
    }
}
