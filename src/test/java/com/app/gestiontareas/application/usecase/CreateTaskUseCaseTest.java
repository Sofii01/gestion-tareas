package com.app.gestiontareas.application.usecase;

import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.domain.port.output.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateTaskUseCaseTest {
    @Mock
    TaskRepository repo;
    @InjectMocks
    CreateTaskUseCase useCase;
    @Test
    void shouldCreateTask() {

        String title = "Aprender arquitectura";
        Task expected = new Task(UUID.randomUUID(), title, false);

        when(repo.save(any())).thenReturn(expected);

        Task result = useCase.createTask(title);

        assertEquals(title, result.getTitle());
        assertFalse(result.isCompleted());
    }

}
