package com.projecto.saude.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.saude.Models.Consulta;
import com.projecto.saude.Models.Exame;
import com.projecto.saude.Repository.ExameRepository;
import com.projecto.saude.service.ExameService;

@RestController
@RequestMapping("/exame")

public class ExameEndpoint {
	
	@Autowired
	private ExameService es;
	@Autowired
	private ExameRepository dao;
	
	
	//LIST ALL

		@GetMapping(value="/listarExames")
		@ResponseStatus(HttpStatus.OK)
		public ModelAndView exameLista() {
			ModelAndView mv= new ModelAndView("listaExames");
			Iterable<Exame> exames= dao.findAll();
			mv.addObject("exames", exames);
	        return mv;
			
		}
		
	//SAVE
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public String adicionar (Exame exame) {
				dao.save(exame);
				return "SUCESSO";
		}			
	//UPDATE

	@GetMapping(value="/updateExame/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Exame exame=es.getExameById(id);
		ModelAndView mv =new ModelAndView("updateExame");
		mv.addObject("exame", exame);
		return mv;
	}
	//DELETE
	    
	    @GetMapping(value="/deleteExame/{id}")
	    @ResponseStatus(HttpStatus.OK)
		public String deleteExame(@PathVariable (value = "id") long id) {
	    	
	    	this.es.getExameById(id);
	    	return "redirect:/exame/listarExames";
	}
	   
	    
	   

}
