package com.anzay.eventos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anzay.eventos.domain.TipoParticipante;

@Repository
public interface TipoParticipanteRepository extends JpaRepository<TipoParticipante, Integer>{

}
