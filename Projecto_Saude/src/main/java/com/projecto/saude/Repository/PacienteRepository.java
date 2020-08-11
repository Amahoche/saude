package com.projecto.saude.Repository;




import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Paciente;



@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	public Optional<Paciente>findByNomeIgnoreCaseContaining(String nome);
	
		
	
	}

