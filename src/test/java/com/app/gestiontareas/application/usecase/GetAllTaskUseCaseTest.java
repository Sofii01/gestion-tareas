package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetAllTaskUseCaseTest {
    @Mock
    TaskRepository repository;
    @InjectMocks
    GetAllTaskUseCase getAll;

    @Test
    void shouldReturnAllTasks() {
        Task task1 = new Task(UUID.randomUUID(), "Estudiar patrones de diseño", false);
        Task task2 = new Task(UUID.randomUUID(), "Practicar consultas de base de datos", false);
        Task task3 = new Task(UUID.randomUUID(), "Investigar sobre IA generativa", false);
        when(repository.findAll()).thenReturn(List.of(task1, task2, task3));
        List<Task> tasks = this.getAll.getAllTasks();
        assertEquals(3, tasks.size());
        assertTrue(tasks.contains(task1));
        assertTrue(tasks.contains(task2));
        assertTrue(tasks.contains(task3));

    }
    @Test
    void shouldReturnEmptyListWhenNoTasksExist() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        List<Task> tasks = this.getAll.getAllTasks();
        assertNotNull(tasks);
        assertTrue(tasks.isEmpty());
    }
}
