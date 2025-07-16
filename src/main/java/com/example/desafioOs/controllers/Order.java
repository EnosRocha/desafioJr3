package com.example.desafioOs.controllers;

import com.example.desafioOs.dtos.OrdemRequestDTO;
import com.example.desafioOs.dtos.OrdersResponseDTO;
import com.example.desafioOs.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class Order {

    private final OrderService orderService;

    public Order(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity newOrder(@Valid @RequestBody OrdemRequestDTO order) {

        boolean response = orderService.createOrder(order);
        if (!response) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/status")
    public String getStatus(@PathVariable (value = "id")Long id){
            return orderService.getStatus(id);
    }

    @GetMapping
    public List<OrdersResponseDTO> getAllOrderByStatusEndPoint(@RequestParam String status){
              return  orderService.getAllOrdersService().stream().filter(n -> n.getStatus().name().equals(status)).map(
                      order -> new OrdersResponseDTO(
                              order.getOrdemId(),
                              order.getCreatedAt(),
                              order.getDescription(),
                              order.getPrice(),
                              order.getStatus().name(),
                              order.getClient().getId()
                      )
              ).collect(Collectors.toList());


    }
}
