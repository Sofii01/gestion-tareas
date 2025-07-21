package com.app.gestiontareas.infrastructure.controllers.dtos;

import jakarta.validation.constraints.NotBlank;



public class CreateTaskRequest {
    @NotBlank(message = "Title cannot be empty")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
