package com.projecto.saude.service;

import java.util.List;

import com.projecto.saude.Models.Exame;


public interface ExameService {
	//SAVE
	void saveExame(Exame exame);
//LIST ALL
	List<Exame> getAllExames();
	//UPDATE
		Exame getExameById(long id);
		//DELETE
		void deleteExameById(long id);

}
