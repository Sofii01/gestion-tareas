package com.app.gestiontareas.infrastructure.controllers;

import com.app.gestiontareas.application.usecase.CreateTaskUseCase;
import com.app.gestiontareas.application.usecase.GetAllTaskUseCase;
import com.app.gestiontareas.application.usecase.GetTaskUseCase;
import com.app.gestiontareas.domain.model.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CreateTaskUseCase createTask;
    @MockBean
    private GetTaskUseCase getTask;

    @MockBean
    private GetAllTaskUseCase getAllTask;
    @Test
    void shouldCreateTask() throws Exception {
        Task expectedTask = new Task(UUID.randomUUID(), "Practicar pruebas", false);
        when(createTask.createTask("Practicar pruebas")).thenReturn(expectedTask);
        mockMvc.perform(post("/api/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Practicar pruebas\"}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Practicar pruebas"));
    }
    @Test
    void shouldReturnTask() throws Exception {
        UUID id = UUID.randomUUID();
        Task expectedTask = new Task(id, "Practicar pruebas", false);
        when(getTask.findTaskById(id)).thenReturn(expectedTask);
        mockMvc.perform(get("/api/task/byId").param("id", id.toString()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id.toString()))
                .andExpect(jsonPath("$.title").value("Practicar pruebas"))
                .andExpect(jsonPath("$.completed").value(false));

    }
    @Test
    void shouldReturnAllTasks() throws Exception {
        Task t1 = new Task(UUID.randomUUID(), "Practicar pruebas unitarias", false);
        Task t2 = new Task(UUID.randomUUID(), "Practicar mockito", false);
        Task t3 = new Task(UUID.randomUUID(), "Practicar pruebas automatizadas", false);
        when(getAllTask.getAllTasks()).thenReturn(List.of(t1, t2, t3));
        mockMvc.perform(get("/api/task"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$[0].title").value("Practicar pruebas unitarias"))
                .andExpect(jsonPath("$[1].title").value("Practicar mockito"))
                .andExpect(jsonPath("$[2].title").value("Practicar pruebas automatizadas"));
    }
}
