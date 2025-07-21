package com.app.gestiontareas.infrastructure.repository;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
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

    public TaskRepositoryImpl(TaskJpaSpringData jpa) {
        this.jpa = jpa;
    }


    @Override
    public Task save(Task task) {
        TaskJpaEntity entity = new TaskJpaEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setCompleted(task.isCompleted());
        Task domain = toDomain(jpa.save(entity));
        return domain;
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return jpa.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(UUID id) {
        jpa.deleteById(id);
    }
    private Task toDomain(TaskJpaEntity entity) {
        return new Task(entity.getId(), entity.getTitle(), entity.isCompleted());
    }

}
