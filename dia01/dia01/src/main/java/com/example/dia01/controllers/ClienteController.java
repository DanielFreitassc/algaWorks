package com.example.dia01.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Cliente saveCliente(@RequestBody Cliente cliente) {
       return clienteRepository.save(cliente);

    }

    @PutMapping("{clienteId}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long clienteId,@RequestBody Cliente cliente) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{clienteId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clienteId) {

        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
    
}