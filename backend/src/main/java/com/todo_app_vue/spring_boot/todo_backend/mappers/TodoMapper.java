package com.todo_app_vue.spring_boot.todo_backend.mappers;

import com.todo_app_vue.spring_boot.todo_backend.domain.entities.TodoEntity;
import com.todo_app_vue.spring_boot.todo_backend.dtos.response.TodoResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoEntity dtoToEntity(TodoResponseDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setTitle(dto.title());
        entity.setCompleted(dto.completed());
        return entity;
    }

    public TodoResponseDto entityToDto(TodoEntity entity) {
        return new TodoResponseDto(entity.getTitle(), entity.isCompleted());
    }
}
