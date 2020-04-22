package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.FaixaEtaria;

@Repository
public interface FaixaEtariaRepository extends JpaRepository<FaixaEtaria, Integer>{

}
