package com.projecto.saude.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteRepository;


@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	private PacienteRepository dao;
	//FIND ALL
	@Override
	public List<Paciente> getAllPacientes(){
		return dao.findAll();
	}
//SAVE
	@Override
	public void savePaciente(Paciente paciente) {
		this.dao.save(paciente);
		
	}
//UPDATE
	@Override
	public Paciente getPacienteById(long id) {
		Optional<Paciente> optional = dao.findById(id);
		Paciente paciente = null;
		if(optional.isPresent()) {
			paciente = optional.get();
		}
		else {
			throw new RuntimeException("Paciente nao Encontrado para o id :: " +id);
		}
		return paciente;
	}
	
	//DELETE
	@Override
	public void deletePacienteById(long id) {
		
		
		this.dao.deleteById(id);
		
	}
	@Override
	public Page<Paciente> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findAll(pageable);
	}
	
	}



