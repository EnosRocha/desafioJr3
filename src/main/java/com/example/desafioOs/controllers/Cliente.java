package com.example.desafioOs.controllers;

import com.example.desafioOs.dtos.ClientRequestDTO;
import com.example.desafioOs.dtos.OrdersResponseDTO;
import com.example.desafioOs.models.OrdemDeServico;
import com.example.desafioOs.repositories.ClientRepository;
import com.example.desafioOs.service.ClientService;
import jakarta.validation.Valid;
import org.hibernate.query.NativeQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class Cliente {
    private final ClientService clientService;

    public Cliente(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity registro(@Valid @RequestBody ClientRequestDTO client) {
        boolean response = clientService.createNeCostumer(client);
        if (!response) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}/orders")
    public List<OrdersResponseDTO> getAllOrders(@PathVariable(value = "id") Long clienteId) {
        List<OrdersResponseDTO> response = clientService.getAllOrders(clienteId);
        return response;


    }


}
