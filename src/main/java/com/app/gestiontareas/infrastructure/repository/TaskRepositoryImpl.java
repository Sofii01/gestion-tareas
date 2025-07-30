package com.app.gestiontareas.infrastructure.repository;

import com.app.gestiontareas.domain.exception.TaskNotFoundException;
import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;
import com.app.gestiontareas.infrastructure.controllers.dtos.UpdateTaskRequestDto;
import com.app.gestiontareas.infrastructure.controllers.mappers.TaskMapper;
import com.app.gestiontareas.infrastructure.repository.jpa.TaskJpaEntity;
import com.app.gestiontareas.infrastructure.repository.jpa.TaskJpaSpringData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class TaskRepositoryImpl implements TaskRepository {
    private final TaskJpaSpringData jpa;
    private final TaskMapper mapper;
    public TaskRepositoryImpl(TaskJpaSpringData jpa, TaskMapper mapper) {
        this.jpa = jpa;
        this.mapper = mapper;
    }


    @Override
    public TaskResponseDto save(Task task) {
        TaskJpaEntity entity = new TaskJpaEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setCompleted(task.isCompleted());
        Task domain = toDomain(jpa.save(entity));
        return mapper.toDto(domain);
    }

    @Override
    public TaskResponseDto findById(UUID id) {
        Optional<Task> optional = jpa.findById(id).map(this::toDomain);
        if (optional.isEmpty()){
            throw new TaskNotFoundException(id);
        }
        return mapper.toDto(optional.get());
    }

    @Override
    public List<TaskResponseDto> findAll() {
        return jpa.findAll().stream().map((entity)->{
            Task t = toDomain(entity);
            return mapper.toDto(t);
        }).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        TaskJpaEntity task = mapper.toJpa(findById(id));
        jpa.delete(task);
    }

    @Override
    public TaskResponseDto update(UUID id, UpdateTaskRequestDto request) {
        TaskJpaEntity task =mapper.toJpa( findById(id));
        task.setTitle(request.getTitle());
        task.setCompleted(request.isCompleted());
        Task d = toDomain(jpa.save(task));
        return mapper.toDto(d);
    }

    @Override
    public void markAsComplete(UUID id) {
        TaskJpaEntity task =mapper.toJpa( findById(id));
        task.setCompleted(true);
        jpa.save(task);
    }

    @Override
    public void markAsUncompleted(UUID id) {
        TaskJpaEntity task =mapper.toJpa( findById(id));
        task.setCompleted(false);
    }

    private Task toDomain(TaskJpaEntity entity) {
        return new Task(entity.getId(), entity.getTitle(), entity.isCompleted());
    }

}
