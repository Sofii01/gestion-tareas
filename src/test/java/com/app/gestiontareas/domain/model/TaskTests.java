package com.app.gestiontareas.domain.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskTests {

    @Test
    void shouldBeMarkCompleted(){
        Task task = new Task(UUID.randomUUID(), "Leer libro", false );
        task.markCompleted();
        assertTrue(task.isCompleted());
    }
    @Test
    void shouldBeMarkPending(){
        Task task = new Task(UUID.randomUUID(), "Leer libro de filosofia", true );
        task.markPending();
        assertFalse(task.isCompleted());
    }
}
