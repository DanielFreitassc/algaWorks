package com.example.dia01.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.example.dia01.models.Parcelamento;
import com.example.dia01.repository.ParcelamentoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;

    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento) {
        novoParcelamento.setDataCriacao(LocalDateTime.now());

        return parcelamentoRepository.save(novoParcelamento);
    }
    
}
