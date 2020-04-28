package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.Modalidade;

@Repository
public interface InscricaoCompeticaoRepository extends JpaRepository<Modalidade, Integer>{

}
