package com.projecto.saude.Controller;






import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteFiltro;
import com.projecto.saude.Repository.PacienteRepository;
import com.projecto.saude.service.PacienteService;




@RestController
@RequestMapping("/paciente")
public class PacienteEndpoint {
	
    @Autowired
    private PacienteService ps;
  
    @Autowired
	private  PacienteRepository dao;
	
	
//LIST ALL

	@GetMapping(value="/listarPacientes")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView lista() {
		ModelAndView mv= new ModelAndView("lista");
		Iterable<Paciente> pacientes= dao.findAll();
		mv.addObject("pacientes", pacientes);
        return mv;
		
	}

    //
    @GetMapping(value="/NovoPaciente")
 	@ResponseStatus(HttpStatus.OK)
	public String NovoPaciente(Model model) {
		Paciente paciente =new Paciente();
		model.addAttribute("paciente", paciente);
		return "teste";
	}
//SAVE
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (Paciente paciente) {
			dao.save(paciente);
			return "SUCESSO!";
			}
//UPDATE
	@GetMapping(value="/updatePaciente/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Paciente paciente=ps.getPacienteById(id);
		ModelAndView mv =new ModelAndView("editarPaciente");
		mv.addObject("paciente", paciente);
		return mv;
	}
//DELETE
    
    @GetMapping(value="/deletePaciente/{id}")
	public String deletePaciente(@PathVariable (value = "id") long id) {
    	
    	this.ps.deletePacienteById(id);
    	return "redirect:/listarPacientes";
}
    
  /**FILTRO
    @PostMapping("/pesquisaPaciente")
	public ModelAndView pesquisar(@RequestParam("nomepesquisa") String nomepesquisa) {
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("pacientes", dao.findByNomeIgnoreCaseContaining(nomepesquisa));
		return mv;

	}**/
    //PESQUISA POR NOME
    @GetMapping("/pesquisaPaciente")
	public ModelAndView pesquisar(PacienteFiltro pacientefiltro, BindingResult result,
			@PageableDefault(size = 2) Pageable pageable, HttpServletRequest httpServletRequest) {
		ModelAndView mv = new ModelAndView("lista");

		PageWrapper<Paciente> paginaWrapper = new PageWrapper<Paciente>();
		mv.addObject("pacientefiltro", paginaWrapper);
		//mv.addObject("pagina", paginaWrapper);

		return mv;

	}

   
     
    
}

