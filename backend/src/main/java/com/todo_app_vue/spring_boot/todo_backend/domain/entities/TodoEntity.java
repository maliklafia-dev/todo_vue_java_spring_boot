package com.todo_app_vue.spring_boot.todo_backend.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="todo")
@Setter
@Getter
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title")
    private String title;

    @Column(name="completed")
    private boolean completed;
}
