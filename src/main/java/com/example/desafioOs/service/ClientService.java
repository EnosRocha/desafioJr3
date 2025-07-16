package com.example.desafioOs.service;

import com.example.desafioOs.Exceptions.ClientAlreadyExistException;
import com.example.desafioOs.Exceptions.ClientNotFoundException;
import com.example.desafioOs.dtos.ClientRequestDTO;
import com.example.desafioOs.dtos.OrdersResponseDTO;
import com.example.desafioOs.models.Cliente;
import com.example.desafioOs.models.OrdemDeServico;
import com.example.desafioOs.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Transactional
    public boolean createNeCostumer(ClientRequestDTO clientDTO) {
        Cliente newCostumer = new Cliente();
        newCostumer.setName(clientDTO.name());
        newCostumer.setEmail(clientDTO.email());
        newCostumer.setPhone(clientDTO.phone());
        clientRepository.save(newCostumer);
        return true;
    }

    public Cliente findCostumerById(Long id) {
        var client = clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Costumer not found"));
        return client;
    }

    public List<OrdersResponseDTO> getAllOrders(Long id) {
        Cliente cliente = clientRepository.findById(id).orElseThrow(
                () -> new ClientNotFoundException("Costumer not found"));


        return cliente.getOrdens().stream().map(n -> (
                new OrdersResponseDTO(
                        n.getOrdemId(),
                        n.getCreatedAt(),
                        n.getDescription(),
                        n.getPrice(),
                        n.getStatus().name(),
                        n.getClient().getId()
                )

        )).collect(Collectors.toList());

    }
}
