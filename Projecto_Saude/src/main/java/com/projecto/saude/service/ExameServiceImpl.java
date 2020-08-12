package com.projecto.saude.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Exame;

import com.projecto.saude.Repository.ExameRepository;

@Service
public class ExameServiceImpl implements ExameService {
@Autowired
private ExameRepository dao;
	@Override
	public void saveExame(Exame exame) {
		this.dao.save(exame);
		
		
	}
	@Override
	public List<Exame> getAllExames() {
		
		return dao.findAll();
	}
	@Override
	public Exame getExameById(long id) {
		Optional<Exame> optional = dao.findById(id);
		Exame exame = null;
		if(optional.isPresent()) {
			exame = optional.get();
		}
		else {
			throw new RuntimeException("Exame nao Encontrado para o id :: " +id);
		}
		return exame;
	}
	@Override
	public void deleteExameById(long id) {
		this.dao.deleteById(id);
		
	}

}
