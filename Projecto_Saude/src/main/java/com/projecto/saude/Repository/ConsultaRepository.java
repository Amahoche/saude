package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Consulta;

@Repository
public interface ConsultaRepository  extends JpaRepository<Consulta, Long>{

}
