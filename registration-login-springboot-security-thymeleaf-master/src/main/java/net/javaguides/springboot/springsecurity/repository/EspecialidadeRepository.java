package net.javaguides.springboot.springsecurity.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.springsecurity.model.Especialidade;

public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long>{
		List<Especialidade> findByNomeIgnoreCaseContaining(String nome);
		Optional<Especialidade> findById(Long id);
}
