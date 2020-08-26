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
import com.projecto.saude.Models.Funcionario;
import com.projecto.saude.Repository.CidadeRepository;
import com.projecto.saude.Repository.FuncionarioRepository;
import com.projecto.saude.service.CidadeService;
import com.projecto.saude.service.FuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired private FuncionarioRepository fr;
	@Autowired private FuncionarioService fs;
	@Autowired private CidadeRepository cr;
	@Autowired private CidadeService cs;
	
	//LIST ALL
		@GetMapping("/funcionarios")
		public ModelAndView listarFuncionarios() {
			ModelAndView mv= new ModelAndView("funcionario");
			Iterable<Funcionario> funcionarios= fr.findAll();
			mv.addObject("funcionarios", funcionarios);
			Iterable<Cidade> cidades= cr.findAll();
			mv.addObject("cidades", cidades);
	        return mv;
		}
		//SAVE TO DB
		@PostMapping("/funcionarios/agendar")
		public String agendar(Funcionario funcionario, Cidade cidade) {
			fs.save(funcionario);
			cs.save(cidade);
			return "redirect:/funcionarios";
		}
		//LIST ONE BY OWN ID
		@RequestMapping("funcionarios/findById")
		@ResponseBody
		public Optional<Funcionario> findById(long id) {
			return fs.findById(id);
		}
		//EDIT OR REPLACE
		@RequestMapping(value="funcionarios/editar", method= {RequestMethod.PUT, RequestMethod.GET})
		public String editar(Funcionario funcionario) {
			fs.save(funcionario);
			return "redirect:/funcionarios";
		}
		//DELETE
		@RequestMapping(value="funcionarios/apagar", method= {RequestMethod.DELETE, RequestMethod.GET})
		public String apagar(Long id) {
			fs.deleteById(id);
			return "redirect:/funcionarios";
		}

}
