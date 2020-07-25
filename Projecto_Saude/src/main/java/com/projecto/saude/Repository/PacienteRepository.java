package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{


}
