package com.example.dia01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dia01.models.Parcelamento;

public interface ParcelamentoRepository extends JpaRepository<Parcelamento,Long> {
    
}
