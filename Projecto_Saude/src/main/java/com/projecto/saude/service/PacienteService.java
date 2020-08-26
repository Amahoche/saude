package com.projecto.saude.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteRepository;
@Service

public class PacienteService {
	
	@Autowired PacienteRepository pr;
	//LIST ALL
	public List<Paciente> getPacientes(){
		return pr.findAll();
	}
	//SAVE TO DB
	public void save(Paciente paciente) {
		pr.save(paciente);
	}
	//LIST ONE BY OWN ID
	public Optional<Paciente> findById(long id) {
		return pr.findById(id);
	}
	//DELETE
	public void deleteById(Long id) {
		pr.deleteById(id);

	}
	public Object findByUsername(String un) {
		// TODO Auto-generated method stub
		return null;
	}
}