package com.projecto.saude.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Cidade;
import com.projecto.saude.Repository.CidadeRepository;

@Service
public class CidadeService {

@Autowired private CidadeRepository cr;
	
	//LIST ALL
		public List<Cidade> getCidades(){
			return cr.findAll();
		}
		//SAVE TO DB
		public void save(Cidade cidade) {
			cr.save(cidade);
		}
		//LIST ONE BY OWN ID
		public Optional<Cidade> findById(long id) {
			return cr.findById(id);
		}
		//DELETE
		public void deleteById(Long id) {
			cr.deleteById(id);

		}
}
