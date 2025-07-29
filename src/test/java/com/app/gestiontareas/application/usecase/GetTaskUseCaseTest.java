package com.app.gestiontareas.application.usecase;


import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetTaskUseCaseTest {
    @Mock
    TaskRepository repository;
    @InjectMocks
    GetTaskUseCase useCase;

    @Test
    void shouldReturnTask() {
        UUID id = UUID.randomUUID();
        Task task = new Task(id, "Estudiar Mockito", false);
        when(repository.findById(id)).thenReturn(Optional.of(task));
        Task result = useCase.findTaskById(task.getId());

        assertNotNull(result);
        assertEquals(task, result);
        assertEquals(id, result.getId());
        assertEquals("Estudiar Mockito", result.getTitle());
    }
}
