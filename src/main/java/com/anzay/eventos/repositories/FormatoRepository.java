package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Formato;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Integer>{

}
