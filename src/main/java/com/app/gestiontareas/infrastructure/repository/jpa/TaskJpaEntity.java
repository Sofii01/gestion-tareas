package com.app.gestiontareas.infrastructure.repository.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tasks")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class TaskJpaEntity {
    @Id
    private UUID id;
    private String title;
    private boolean completed;



}
