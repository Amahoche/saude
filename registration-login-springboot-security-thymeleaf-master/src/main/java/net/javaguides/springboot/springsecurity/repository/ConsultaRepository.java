/**package net.javaguides.springboot.springsecurity.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.Consulta;
@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {
	
	Consulta findByconsultaIgnoreCaseContaining(String consulta);
	Optional<Consulta> findById(Long id);

}**/
