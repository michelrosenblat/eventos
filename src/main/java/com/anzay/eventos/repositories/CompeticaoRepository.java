package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Competicao;

@Repository
public interface CompeticaoRepository extends JpaRepository<Competicao, Integer>{

}
