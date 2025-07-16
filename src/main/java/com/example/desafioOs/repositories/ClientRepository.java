package com.example.desafioOs.repositories;


import com.example.desafioOs.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);

}
