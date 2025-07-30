package com.app.gestiontareas.infrastructure.controllers;


import com.app.gestiontareas.application.usecase.*;
import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.infrastructure.controllers.dtos.CreateTaskRequest;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;
import com.app.gestiontareas.infrastructure.controllers.dtos.UpdateTaskRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tasks", description = "tasks operations")
public class TaskController {

    private final CreateTaskUseCase createTask;
    private final GetTaskUseCase getTask;
    private final GetAllTaskUseCase getAllTask;
    private final UpdateTaskUseCase updateTask;
    private final DeleteTaskUseCase deleteTask;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTask, GetAllTaskUseCase getAllTask, UpdateTaskUseCase updateTask, DeleteTaskUseCase deleteTask) {
        this.createTask = createTaskUseCase;
        this.getTask = getTask;
        this.getAllTask = getAllTask;
        this.updateTask = updateTask;
        this.deleteTask = deleteTask;
    }


    @PostMapping
    @Operation(summary = "Create a task")
    public ResponseEntity<TaskResponseDto> create(@Valid @RequestBody CreateTaskRequest createTaskRequest) {
        String title = createTaskRequest.getTitle();
        return new ResponseEntity<>(createTask.createTask(title), HttpStatus.CREATED);
    }
    @GetMapping("/byId")
    @Operation(summary = "Get a task by id", description = "Find a task by id")
    public ResponseEntity<TaskResponseDto> getTask(@RequestParam UUID id) {
        TaskResponseDto task = getTask.findTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @GetMapping
    @Operation(summary = "Get all task", description = "Return all of tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks() {
        List<TaskResponseDto> list = getAllTask.getAllTasks();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    @Operation(summary = "Delete a task", description = "Delete a task by id")
    public ResponseEntity<?> deleteTask(@RequestParam UUID id) {
        deleteTask.deleteTask(id);
        return new ResponseEntity<>("Task has been deleted.", HttpStatus.OK);
    }
    @PutMapping("/update")
    @Operation(summary = "Update a task")
    public ResponseEntity<TaskResponseDto> updateTask(@Valid @RequestBody UpdateTaskRequestDto requestDto){
        TaskResponseDto task = updateTask.updateTask(requestDto);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

}
