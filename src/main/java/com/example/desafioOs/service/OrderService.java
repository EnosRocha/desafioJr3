package com.example.desafioOs.service;

import com.example.desafioOs.Exceptions.ClientNotFoundException;
import com.example.desafioOs.Exceptions.OrderNotFoundException;
import com.example.desafioOs.components.Status;
import com.example.desafioOs.dtos.OrdemRequestDTO;
import com.example.desafioOs.dtos.OrdersResponseDTO;
import com.example.desafioOs.models.Cliente;
import com.example.desafioOs.models.OrdemDeServico;
import com.example.desafioOs.repositories.ClientRepository;
import com.example.desafioOs.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public boolean createOrder(OrdemRequestDTO ordemRequestDTO
    ) {
        Cliente client = clientRepository.findById(ordemRequestDTO.ClientId()
        ).orElseThrow(() -> new ClientNotFoundException("Client not found"));

        OrdemDeServico order = new OrdemDeServico();
        order.setClient(client);
        order.setDescription(ordemRequestDTO.description());
        order.setPrice(ordemRequestDTO.price());
        order.setCreatedAt(OffsetDateTime.now());
        order.setStatus(Status.valueOf(ordemRequestDTO.status().name()));
        orderRepository.save(order);
        return true;
    }


    @Transactional
    public String getStatus(Long orderId) {
        var orderResponse = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
        return orderResponse.getStatus().name();
    }

    @Transactional
    public List<OrdemDeServico> getAllOrdersService(){
        List<OrdemDeServico> allOrders = orderRepository.findAll();
        return allOrders;
    }

}
