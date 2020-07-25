package com.projecto.saude.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.projecto.saude.Models.Paciente;

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

}
