package com.projecto.saude.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Cidade;
@Repository

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
