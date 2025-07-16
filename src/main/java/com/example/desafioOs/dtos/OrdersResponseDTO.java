package com.example.desafioOs.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record OrdersResponseDTO(Long orderId, OffsetDateTime createdAt, String description, BigDecimal price, String status, Long cliendId) {
}
