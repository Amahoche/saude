package com.projecto.saude.service;

import java.awt.print.Pageable;
import java.util.List;


import org.springframework.data.domain.Page;

import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteFiltro;

public interface PacienteService {
//LIST ALL
	List<Paciente> getAllPacientes();
	//SAVE
	void savePaciente(Paciente paciente);
	//UPDATE
	Paciente getPacienteById(long id);
	//DELETE
	void deletePacienteById(long id);
	//PAGINATION
	Page<Paciente> findPaginated(int pageNo, int pageSize);
	//FILTRO
	public void filtrar(PacienteFiltro filtro, Pageable pageable);
	//Optional<Paciente> getByNomeIgnoreCaseContaining(String nome);

}
