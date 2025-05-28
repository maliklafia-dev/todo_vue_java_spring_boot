package com.todo_app_vue.spring_boot.todo_backend.controller;

import com.todo_app_vue.spring_boot.todo_backend.domain.entities.Stats;
import com.todo_app_vue.spring_boot.todo_backend.domain.entities.TodoEntity;
import com.todo_app_vue.spring_boot.todo_backend.domain.service.TodoService;
import com.todo_app_vue.spring_boot.todo_backend.dtos.response.StatsResponseDto;
import com.todo_app_vue.spring_boot.todo_backend.dtos.response.TodoResponseDto;
import com.todo_app_vue.spring_boot.todo_backend.mappers.StatsMapper;
import com.todo_app_vue.spring_boot.todo_backend.mappers.TodoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    private final StatsMapper statsMapper;

    public TodoController(TodoService todoService,  TodoMapper todoMapper, StatsMapper statsMapper) {
        this.todoService = todoService;
        this.todoMapper = todoMapper;
        this.statsMapper = statsMapper;
    }

    @GetMapping(value = "/todos", produces = "application/json")
    public ResponseEntity<List<TodoResponseDto>>  getAllTodo(@RequestParam(required = false) boolean completed ) {
        List<TodoResponseDto> todos;
        if(completed) {
            todos = todoService.getCompletedTodos()
                    .stream()
                    .map(todoMapper::entityToDto)
                    .toList();
            return new ResponseEntity<>(todos, HttpStatus.OK) ;
        }
         todos = todoService.getAllTodos()
                .stream()
                .map(todoMapper::entityToDto)
                .toList();
        return new ResponseEntity<>(todos, HttpStatus.OK) ;
    }

    @GetMapping(value="/todos/stats", produces = "application/json")
    public ResponseEntity<StatsResponseDto> getStats() {
        Stats stats = todoService.getStats();
        return new ResponseEntity<>(statsMapper.toDto(stats), HttpStatus.OK);
    }

    @PutMapping(value = "/todos/{id}")
    public ResponseEntity<TodoResponseDto> updateTodo(@RequestBody TodoResponseDto dto, @PathVariable int id) throws Exception {
        TodoEntity entity = todoMapper.dtoToEntity(dto);
        entity.setId(id);
        try {
            return ResponseEntity.ok(todoMapper.entityToDto(todoService.updateTodo(id, entity)));
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping(value = "/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        this.todoService.deleteTodo(id);
    }

}
