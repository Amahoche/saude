package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Tratamento;
@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Long>{

}
