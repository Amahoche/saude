package com.projecto.saude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Funcionario;
import com.projecto.saude.Repository.FuncionarioRepository;

@Service

public class FuncionarioService {
	@Autowired private FuncionarioRepository fr;
	
	//LIST ALL
		public List<Funcionario> getFuncionarios(){
			return fr.findAll();
		}
		//SAVE TO DB
		public void save(Funcionario funcionario) {
			fr.save(funcionario);
		}
		//LIST ONE BY OWN ID
		public Optional<Funcionario> findById(long id) {
			return fr.findById(id);
		}
		//DELETE
		public void deleteById(Long id) {
			fr.deleteById(id);

		}

}
