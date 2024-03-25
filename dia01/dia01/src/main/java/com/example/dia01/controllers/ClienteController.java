package com.example.dia01.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dia01.models.Cliente;
import com.example.dia01.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> getAllCliente() {
        //return clienteRepository.findByNome("daniel");
        //return clienteRepository.findByNomeContaining("daniel");
        return clienteRepository.findAll();
    }

    @GetMapping("{clienteId}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long clienteId) {
       Optional<Cliente> cliente = clienteRepository.findById(clienteId);

       if(cliente.isPresent()) {
        return ResponseEntity.ok(cliente.get());
       }
       return ResponseEntity.notFound().build();
    }
    
}