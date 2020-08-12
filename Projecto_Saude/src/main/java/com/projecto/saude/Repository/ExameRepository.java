package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Long>{

}
