package com.projecto.saude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Especialidade;
import com.projecto.saude.Models.Funcionario;
import com.projecto.saude.Repository.EspecialidadeRepository;
import com.projecto.saude.Repository.FuncionarioRepository;
@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	@Autowired
	private FuncionarioRepository dao;
	@Autowired
	private EspecialidadeRepository er;
//LIST ALL
	@Override
	public List<Funcionario> getAllFuncionarios() {
		
		return dao.findAll();
	}
//SAVE
	@Override
	public void saveFuncionario(Funcionario funcionario) {
		
		this.dao.save(funcionario);
		
	}
//UPDATE
	@Override
	public Funcionario getFuncionarioById(long id) {
		Optional<Funcionario> optional = dao.findById(id);
		Funcionario funcionario = null;
		if(optional.isPresent()) {
			funcionario = optional.get();
		}
		else {
			throw new RuntimeException("Funcionario nao Encontrado para o id :: " +id);
		}
		return funcionario;
	}
//DELETE
	@Override
	public void deleteFuncionarioById(long id) {
		this.dao.deleteById(id);
		
	}
//PAGINATION
	@Override
	public Page<Funcionario> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findAll(pageable);
	}
	
	}


