package com.projecto.saude.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.projecto.saude.Models.Consulta;

public interface ConsultaService {

	//LIST ALL
			List<Consulta> getAllConsultas();
			//SAVE
			void saveConsulta(Consulta consulta);
			//UPDATE
			Consulta getConsultaById(long id);
			//DELETE
			void deleteConsultaById(long id);
			
			
			//PAGINATION
			Page<Consulta> findPaginated(int pageNo, int pageSize);

}
