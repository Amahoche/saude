package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Especialidade;
import com.projecto.saude.Models.Funcionario;

@Repository

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long>{
	
}
