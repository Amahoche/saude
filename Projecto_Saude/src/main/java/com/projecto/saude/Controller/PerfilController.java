package com.projecto.saude.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projecto.saude.service.PacienteService;
@Controller
public class PerfilController {
	@Autowired private PacienteService ps;
	@RequestMapping(value="/perfil")
	public String perfil(Model model, Principal principal) {
		String un = principal.getName();
		model.addAttribute("paciente", ps.findByUsername(un));
		
		return "profile";
				
	}

}
