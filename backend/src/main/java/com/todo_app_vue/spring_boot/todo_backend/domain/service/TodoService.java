package com.todo_app_vue.spring_boot.todo_backend.domain.service;

import com.todo_app_vue.spring_boot.todo_backend.domain.entities.Stats;
import com.todo_app_vue.spring_boot.todo_backend.domain.entities.TodoEntity;
import com.todo_app_vue.spring_boot.todo_backend.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<TodoEntity> getAllTodos() {
        return repository.findAll();
    }

    public TodoEntity updateTodo(int id, TodoEntity updatedTodo) {
        return repository.findById(id)
                .map(todo -> {
                    todo.setTitle(updatedTodo.getTitle());
                    todo.setCompleted(updatedTodo.isCompleted());
                    return repository.save(todo);
                }).orElseThrow(() -> new RuntimeException("No todo found for id : " + id));
    }

    public List<TodoEntity> getCompletedTodos() {
        return repository.findAll()
                .stream()
                .filter(TodoEntity::isCompleted)
                .collect(Collectors.toList());
    }

    public List<TodoEntity> getUncompletedTodos() {
        return repository.findAll()
                .stream()
                .filter(todo -> !todo.isCompleted())
                .collect(Collectors.toList());
    }

    public Stats getStats() {
        Stats stats = new Stats();
        stats.setCompleted(getCompletedTodos().size());
        stats.setPending(getUncompletedTodos().size());
        stats.setTotal(getAllTodos().size());
        return stats;
    }

    public void deleteTodo(int id) {
        repository.deleteById(id);
    }

}
