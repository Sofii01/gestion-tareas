package com.app.gestiontareas.infrastructure.repository;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import com.app.gestiontareas.infrastructure.repository.jpa.TaskJpaSpringData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class TaskRepositoryImplTest {

    private  TaskRepository repository;
    @Autowired
    private TaskJpaSpringData jpa;

    @BeforeEach
    void setUp() {
        repository = new TaskRepositoryImpl(jpa);
    }


    @Test
    void saveAndFindShouldWork() {
        Task task = new Task(UUID.randomUUID(), "Estudiar", false);
        repository.save(task);

        Optional<Task> result = repository.findById(task.getId());

        assertTrue(result.isPresent());
        assertEquals("Estudiar", result.get().getTitle());
    }
    @Test
    void deleteShouldWork() {
        Task task = new Task(UUID.randomUUID(), "Estudiar", false);
        repository.save(task);
        repository.deleteById(task.getId());
        Optional<Task> result = repository.findById(task.getId());
        assertFalse(result.isPresent());
    }
}
