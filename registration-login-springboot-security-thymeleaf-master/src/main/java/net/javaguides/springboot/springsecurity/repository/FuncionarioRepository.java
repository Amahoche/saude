package net.javaguides.springboot.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.springsecurity.model.Funcionario;


public interface FuncionarioRepository extends CrudRepository <Funcionario, Long>{
		Funcionario findByNomeIgnoreCaseContaining(String nome);
	Optional<Funcionario> findById(Long id);
	
	

}
