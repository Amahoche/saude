package com.projecto.saude.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecto.saude.Models.PreNatal;

@Repository
public interface PreNatalRepository extends JpaRepository<PreNatal, Long>{

}
