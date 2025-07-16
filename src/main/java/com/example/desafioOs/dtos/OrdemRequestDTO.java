package com.example.desafioOs.dtos;

import com.example.desafioOs.components.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record OrdemRequestDTO(
        @NotNull Long ClientId,
        @Size(min = 5) String description,
        @Positive BigDecimal price,
        Status status) {
}
