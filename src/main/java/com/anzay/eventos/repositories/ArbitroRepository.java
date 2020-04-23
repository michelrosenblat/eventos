package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Arbitro;

@Repository
public interface ArbitroRepository extends JpaRepository<Arbitro, Integer>{

}
