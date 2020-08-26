package com.projecto.saude.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteRepository;
import com.projecto.saude.service.PacienteService;

@Controller

public class PacienteController {
	@Autowired private PacienteService ps;
	@Autowired private PacienteRepository pr;
	//LIST ALL
	@GetMapping("/pacientes")
	public ModelAndView listarPacientes(Model model ) {
		ModelAndView mv= new ModelAndView("paciente");
		Iterable<Paciente> pacientes= pr.findAll();
		mv.addObject("pacientes", pacientes);
        return mv;
	}
	//SAVE TO DB
	@PostMapping("/pacientes/agendar")
	public String agendar(Paciente paciente) {
		ps.save(paciente);
		return "redirect:/pacientes";
	}
	//LIST ONE BY OWN ID
	@RequestMapping("pacientes/findById")
	@ResponseBody
	public Optional<Paciente> findById(long id) {
		return ps.findById(id);
	}
	//EDIT OR REPLACE
	@RequestMapping(value="pacientes/editar", method= {RequestMethod.PUT, RequestMethod.GET})
	public String editar(Paciente paciente) {
		ps.save(paciente);
		return "redirect:/pacientes";
	}
	//DELETE
	@RequestMapping(value="pacientes/apagar", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String apagar(Long id) {
		ps.deleteById(id);
		return "redirect:/pacientes";
	}
}

