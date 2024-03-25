package com.example.dia01.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dia01.exception.NegocioException;
import com.example.dia01.models.Cliente;
import com.example.dia01.repository.ClienteRepository;


import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CadastrroClienteService {
    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
        .filter(c -> !c.equals(cliente)).isPresent();

        if(emailEmUso) {
           throw new NegocioException("E-mail em já está em uso");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
    
}
