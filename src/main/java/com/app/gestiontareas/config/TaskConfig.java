package com.app.gestiontareas.config;

import com.app.gestiontareas.application.usecase.CreateTaskUseCase;
import com.app.gestiontareas.application.usecase.GetAllTaskUseCase;
import com.app.gestiontareas.application.usecase.GetTaskUseCase;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.repository.TaskRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public CreateTaskUseCase createTaskUseCase(TaskRepository taskRepository) {
        return new CreateTaskUseCase(taskRepository);
    }
    @Bean
    public GetAllTaskUseCase getAllTaskUseCase(TaskRepository taskRepository) {
        return new GetAllTaskUseCase(taskRepository);
    }
    @Bean
    public GetTaskUseCase getTaskUseCase(TaskRepository taskRepository) {
        return new GetTaskUseCase(taskRepository);
    }

}
