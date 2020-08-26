package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
