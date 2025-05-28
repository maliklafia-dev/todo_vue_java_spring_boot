package com.todo_app_vue.spring_boot.todo_backend.repository;

import com.todo_app_vue.spring_boot.todo_backend.domain.entities.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
    List<TodoEntity> id(int id);
}
