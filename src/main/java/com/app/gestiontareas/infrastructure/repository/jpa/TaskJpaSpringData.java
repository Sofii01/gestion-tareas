package com.app.gestiontareas.infrastructure.repository.jpa;

import com.app.gestiontareas.domain.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskJpaSpringData extends JpaRepository<TaskJpaEntity, UUID> {
}
