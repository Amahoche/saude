package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import net.javaguides.springboot.springsecurity.model.Paciente;


public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Long>, CrudRepository <Paciente, Long>{

	Object findByNomeIgnoreCaseContaining(String nome);

	
	
	
	
	
}
