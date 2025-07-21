package com.app.gestiontareas.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class Task {


    private UUID id;
    private String title;
    private boolean completed;

    public Task(UUID id, String title, boolean completed) {
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public void markCompleted() {
        this.completed = true;
    }

    public void markPending() {
        this.completed = false;
    }

}
