package com.projecto.saude.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Endereco;
@Repository
public interface EnderecoRepository  extends JpaRepository<Endereco, Long>{

}
