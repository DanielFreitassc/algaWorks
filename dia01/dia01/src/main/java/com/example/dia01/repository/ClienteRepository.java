package com.example.dia01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dia01.models.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);
    
}
