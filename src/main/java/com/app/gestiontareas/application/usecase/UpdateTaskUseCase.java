package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;
import com.app.gestiontareas.infrastructure.controllers.dtos.UpdateTaskRequestDto;

public class UpdateTaskUseCase {
    private final TaskRepository taskRepository;

    public UpdateTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public TaskResponseDto updateTask(UpdateTaskRequestDto requestDto){
        return taskRepository.update(requestDto.getId(), requestDto);
    }
}
