package net.javaguides.springboot.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.javaguides.springboot.springsecurity.model.Paciente;


public interface PacienteRepository extends CrudRepository <Paciente, Long>{

	Paciente findByNomeIgnoreCaseContaining(String nome);
	Paciente findById(long id);
	Paciente delete(Optional<Paciente> paciente);
	
	
	
	
	
	
}
