package com.example.dia01.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dia01.models.Cliente;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @GetMapping
    public List<Cliente> getAllCliente() {
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Daniel");
        cliente.setEmail("test@test");
        cliente.setTelefone("48 922223455");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Luiz");
        cliente2.setEmail("test@test");
        cliente2.setTelefone("48 922223455");

        Cliente cliente3 = new Cliente();
        cliente3.setId(3L);
        cliente3.setNome("Eduardo");
        cliente3.setEmail("test@test");
        cliente3.setTelefone("48 922223455");

        return Arrays.asList(cliente,cliente2,cliente3);   
    }
    
}
