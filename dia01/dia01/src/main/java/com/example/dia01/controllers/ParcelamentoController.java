package com.example.dia01.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dia01.models.Parcelamento;
import com.example.dia01.repository.ParcelamentoRepository;
import com.example.dia01.services.ParcelamentoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("parcelamentos")
public class ParcelamentoController {

    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentoService parcelamentoService;


    @GetMapping
    public List<Parcelamento> listar() {
       return parcelamentoRepository.findAll();
    }

    @GetMapping("{parcelamentoId}")
    public ResponseEntity<Parcelamento> bucar(@PathVariable Long parcelamentoId) {
        //return parcelamentoRepository.findById(parcelamentoId).map(p -> ResponseEntity.ok(p)).orElse(ResponseEntity.notFound().build());
        return parcelamentoRepository.findById(parcelamentoId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento cadastrar(@RequestBody Parcelamento parcelamento) {
        return parcelamentoService.cadastrar(parcelamento);
    }

    
}
