package com.todo_app_vue.spring_boot.todo_backend.dtos.request;

import lombok.Data;

public record TodoRequestDto(String title, boolean completed) {
}
