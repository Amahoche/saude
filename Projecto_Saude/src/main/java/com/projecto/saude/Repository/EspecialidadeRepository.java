/**package com.projecto.saude.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Especialidade;
import com.projecto.saude.Models.Funcionario;

@Repository

public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long>{
	Iterable <Especialidade> findByFuncionario(Funcionario funcionario);
}**/
