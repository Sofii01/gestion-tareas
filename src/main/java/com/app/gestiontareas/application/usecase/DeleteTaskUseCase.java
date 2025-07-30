package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.port.output.TaskRepository;

import java.util.UUID;

public class DeleteTaskUseCase {
    private final TaskRepository taskRepository;

    public DeleteTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void deleteTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }
}
