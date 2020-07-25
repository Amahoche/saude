package com.projecto.saude.service;

import java.util.List;


import org.springframework.data.domain.Page;

import com.projecto.saude.Models.Funcionario;



public interface FuncionarioService {
	//LIST ALL
		List<Funcionario> getAllFuncionarios();
		//SAVE
		void saveFuncionario(Funcionario funcionario);
		//UPDATE
		Funcionario getFuncionarioById(long id);
		//DELETE
		void deleteFuncionarioById(long id);
		
		
		//PAGINATION
		Page<Funcionario> findPaginated(int pageNo, int pageSize);

}
