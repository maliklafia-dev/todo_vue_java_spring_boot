package com.todo_app_vue.spring_boot.todo_backend.mappers;

import com.todo_app_vue.spring_boot.todo_backend.domain.entities.Stats;
import com.todo_app_vue.spring_boot.todo_backend.dtos.response.StatsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class StatsMapper {

    public StatsResponseDto toDto(Stats stats) {
        return new StatsResponseDto(stats.getTotal(), stats.getCompleted(), stats.getPending());
    }

    public Stats toEntity(StatsResponseDto dto) {
        return new Stats(dto.total(), dto.completed(), dto.pending());
    }
}
