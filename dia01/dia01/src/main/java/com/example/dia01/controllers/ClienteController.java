package com.example.dia01.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dia01.models.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @PersistenceContext
    private EntityManager manager;

    @GetMapping
    public List<Cliente> getAllCliente() {
        return manager.createQuery("from Cliente",Cliente.class).getResultList();
    }
    
}