package com.app.gestiontareas.infrastructure.controllers.mappers;


import com.app.gestiontareas.domain.model.Task;
import com.app.gestiontareas.infrastructure.controllers.dtos.TaskResponseDto;
import com.app.gestiontareas.infrastructure.repository.jpa.TaskJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskResponseDto toDto(Task task);
    TaskJpaEntity toJpa(TaskResponseDto dto);
}
