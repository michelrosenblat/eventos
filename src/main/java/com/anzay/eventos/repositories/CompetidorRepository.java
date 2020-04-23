package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Competidor;

@Repository
public interface CompetidorRepository extends JpaRepository<Competidor, Integer>{

}
