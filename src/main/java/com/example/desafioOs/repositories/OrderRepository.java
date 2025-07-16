package com.example.desafioOs.repositories;

import com.example.desafioOs.models.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrdemDeServico, Long> {

    Optional<OrdemDeServico> findById(Long id);
}
