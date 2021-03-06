package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer>{

}
