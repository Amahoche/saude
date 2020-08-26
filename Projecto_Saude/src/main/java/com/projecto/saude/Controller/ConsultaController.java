package com.projecto.saude.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.saude.Models.Consulta;
import com.projecto.saude.Repository.ConsultaRepository;
import com.projecto.saude.service.ConsultaService;

@Controller
public class ConsultaController {
	@Autowired private ConsultaRepository cr;
	@Autowired private ConsultaService cs;
	
	//LIST ALL
		@GetMapping("/consultas")
		public ModelAndView listarconsultas() {
			ModelAndView mv= new ModelAndView("consulta");
			Iterable<Consulta> consultas= cr.findAll();
			mv.addObject("consultas", consultas);
	        return mv;
		}
		//SAVE TO DB
		@PostMapping("/consultas/marcar")
		public String agendar(Consulta consulta) {
			cs.save(consulta);
			return "redirect:/consultas";
		}
		//LIST ONE BY OWN ID
		@RequestMapping("consultas/findById")
		@ResponseBody
		public Optional<Consulta> findById(long id) {
			return cs.findById(id);
		}
		//EDIT OR REPLACE
		@RequestMapping(value="consultas/editar", method= {RequestMethod.PUT, RequestMethod.GET})
		public String editar(Consulta consulta) {
			cs.save(consulta);
			return "redirect:/consultas";
		}
		//DELETE
		@RequestMapping(value="consultas/apagar", method= {RequestMethod.DELETE, RequestMethod.GET})
		public String apagar(Long id) {
			cs.deleteById(id);
			return "redirect:/consultas";
		}


}
