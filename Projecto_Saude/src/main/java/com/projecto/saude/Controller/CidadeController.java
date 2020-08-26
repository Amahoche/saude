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

import com.projecto.saude.Models.Cidade;
import com.projecto.saude.Repository.CidadeRepository;
import com.projecto.saude.service.CidadeService;
@Controller
public class CidadeController {
	

	@Autowired private CidadeRepository cr;
	@Autowired private CidadeService cs;
	
	//LIST ALL
		@GetMapping("/cidades")
		public ModelAndView listarcidades() {
			ModelAndView mv= new ModelAndView("cidade");
			Iterable<Cidade> cidades= cr.findAll();
			mv.addObject("cidades", cidades);
	        return mv;
		}
		//SAVE TO DB
		@PostMapping("/cidades/agendar")
		public String agendar(Cidade cidade) {
			cs.save(cidade);
			return "redirect:/cidades";
		}
		//LIST ONE BY OWN ID
		@RequestMapping("cidades/findById")
		@ResponseBody
		public Optional<Cidade> findById(long id) {
			return cs.findById(id);
		}
		//EDIT OR REPLACE
		@RequestMapping(value="cidades/editar", method= {RequestMethod.PUT, RequestMethod.GET})
		public String editar(Cidade cidade) {
			cs.save(cidade);
			return "redirect:/cidades";
		}
		//DELETE
		@RequestMapping(value="cidades/apagar", method= {RequestMethod.DELETE, RequestMethod.GET})
		public String apagar(Long id) {
			cs.deleteById(id);
			return "redirect:/cidades";
		}


}
