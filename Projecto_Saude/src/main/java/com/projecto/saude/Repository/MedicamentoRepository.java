package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Medicamento;
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
