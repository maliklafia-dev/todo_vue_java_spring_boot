package com.todo_app_vue.spring_boot.todo_backend.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Stats {
    private int total;
    private int completed;
    private int pending;

    public Stats(int total, int completed, int pending) {
        this.total = total;
        this.completed = completed;
        this.pending = pending;
    }

    public Stats() {}

}
