package com.projecto.saude.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.MedicamentoPaciente;
@Repository
public interface MedicamentoPacienteRepository extends JpaRepository<MedicamentoPaciente, Long> {

}
