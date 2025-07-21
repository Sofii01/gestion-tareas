package com.app.gestiontareas.domain.exception;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(UUID id){
        super("Task with id not found: " +id);
    }
}
