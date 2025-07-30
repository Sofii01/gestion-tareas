package com.app.gestiontareas.infrastructure.controllers;


import com.app.gestiontareas.application.usecase.CreateTaskUseCase;
import com.app.gestiontareas.application.usecase.GetAllTaskUseCase;
import com.app.gestiontareas.application.usecase.GetTaskUseCase;
import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.infrastructure.controllers.dtos.CreateTaskRequest;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CreateTaskUseCase createTask;
    private final GetTaskUseCase getTask;
    private final GetAllTaskUseCase getAllTask;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTask, GetAllTaskUseCase getAllTask) {
        this.createTask = createTaskUseCase;
        this.getTask = getTask;
        this.getAllTask = getAllTask;
    }


    @PostMapping
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        String title = createTaskRequest.getTitle();
        return new ResponseEntity<>(createTask.createTask(title), HttpStatus.CREATED);
    }
    @GetMapping("/byId")
    public ResponseEntity<TaskResponseDto> getTask(@RequestParam UUID id) {
        TaskResponseDto task = getTask.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> list = getAllTask.getAllTasks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
