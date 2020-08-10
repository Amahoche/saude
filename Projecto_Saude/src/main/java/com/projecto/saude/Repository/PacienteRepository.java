package com.projecto.saude.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Paciente;
import com.projecto.saude.service.PacienteService;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>, PacienteService{
	public Optional<Paciente>findByNomeIgnoreCaseContaining(String nome);
	
		
	
	}

