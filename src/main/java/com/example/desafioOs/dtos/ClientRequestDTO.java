package com.example.desafioOs.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientRequestDTO(
        @NotBlank String name,
        @Email @NotBlank String email,
        @NotBlank @Pattern(regexp = "^\\(\\d{2}\\)\\d{5}\\-\\d{4}$") String phone
        ) {
}
