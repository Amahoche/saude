package com.projecto.saude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Consulta;
import com.projecto.saude.Repository.ConsultaRepository;

@Service
public class ConsultaServiceImpl implements ConsultaService{
	@Autowired
	private ConsultaRepository dao;
//LIST ALL
	@Override
	public List<Consulta> getAllConsultas() {
		
		return dao.findAll();
	}
//SAVE
	@Override
	public void saveConsulta(Consulta consulta) {
		this.dao.save(consulta);
		
	}
//UPDAATE
	@Override
	public Consulta getConsultaById(long id) {
		Optional<Consulta> optional = dao.findById(id);
		Consulta consulta = null;
		if(optional.isPresent()) {
			consulta = optional.get();
		}
		else {
			throw new RuntimeException("Consulta nao Encontrada para o id :: " +id);
		}
		return consulta;
	}
//DELETE
	@Override
	public void deleteConsultaById(long id) {
		this.dao.deleteById(id);
		
	}
//PAGINATION
	@Override
	public Page<Consulta> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findAll(pageable);
	}

}
