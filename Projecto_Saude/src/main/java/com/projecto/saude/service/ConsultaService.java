package com.projecto.saude.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.saude.Models.Consulta;
import com.projecto.saude.Repository.ConsultaRepository;
@Service
public class ConsultaService {
@Autowired private ConsultaRepository cr;
	
	//LIST ALL
		public List<Consulta> getConsultas(){
			return cr.findAll();
		}
		//SAVE TO DB
		public void save(Consulta consulta) {
			cr.save(consulta);
		}
		//LIST ONE BY OWN ID
		public Optional<Consulta> findById(long id) {
			return cr.findById(id);
		}
		//DELETE
		public void deleteById(Long id) {
			cr.deleteById(id);

		}

}
