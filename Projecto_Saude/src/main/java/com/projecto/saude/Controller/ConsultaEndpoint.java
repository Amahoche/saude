package com.projecto.saude.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.projecto.saude.Models.Consulta;
import com.projecto.saude.Repository.ConsultaRepository;
import com.projecto.saude.service.ConsultaService;


@RestController
@RequestMapping("/consulta")
public class ConsultaEndpoint {
	
	@Autowired
  private ConsultaService cs;
  
    @Autowired
	private ConsultaRepository dao;
	
	
//LIST ALL

	@GetMapping(value="/listarConsultas")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView consultaLista() {
		ModelAndView mv= new ModelAndView("consultaLista");
		Iterable<Consulta> consultas= dao.findAll();
		mv.addObject("consultas", consultas);
        return mv;
		
	}

    //
    @GetMapping(value="/NovaConsulta")
 	@ResponseStatus(HttpStatus.OK)
	public String NovoConsulta(Model model) {
		Consulta consulta = new Consulta();
		model.addAttribute("consulta", consulta);
		return "worker";
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (Consulta consulta) {
			dao.save(consulta);
			return "dashboard";
			}
	/**SAVE FUNCIONARIO
	 @PostMapping("/adicionarConsulta")
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (@ModelAttribute("consulta") Consulta consulta) {
    	cs.saveConsulta(consulta);
			return "redirect:/dashboard";
			}**/
    //UPDATE

@GetMapping(value="/updateConsulta/{id}")
 	@ResponseStatus(HttpStatus.OK)
	public String editar(@PathVariable (value = "id") long id, Model model) {
		
		//GET PACIENTE FROM SERVICE
		Consulta consulta = cs.getConsultaById(id);
		//SET PACIENTE AS MODEL ATTRIBUTE TO PRE-POPULATE FORM
		model.addAttribute("consulta", consulta);
		return "redirect:/updateConsulta";
	}
//DELETE
    
    @GetMapping(value="/deleteConsulta/{id}")
    @ResponseStatus(HttpStatus.OK)
	public String deleteConsulta(@PathVariable (value = "id") long id) {
    	
    	this.cs.deleteConsultaById(id);
    	return "redirect:/consulta/listarConsultas";
}
   /**PAGINATION METHOD 
    @GetMapping(value="/page/{pageNo}")
    public String findPaginated(@PathVariable (value= "pageNo") int pageNo, Model model) {
    	int pageSize = 5;
    	Page<Funcionario> page = fs.findPaginated(pageNo, pageSize);
    	List<Funcionario> listFuncionarios = page.getContent();
    	model.addAttribute("currentPage", pageNo);
    	model.addAttribute("totalPage", page.getTotalPages());
    	model.addAttribute("totalItems", page.getTotalElements());
    	model.addAttribute("listFuncionarios", listFuncionarios);
    
    	return "paciente/listarFuncionarios";
    }
    
    @GetMapping("id")
    public ModelAndView detalhesFuncionario(@PathVariable(value = "id") long id) {
    	Optional<Funcionario> funcionario = dao.findById(id);
    	ModelAndView mv = new ModelAndView("detalhesFuncionario");
    	mv.addObject("funcionario", funcionario);
    	return mv;
    }**/
}
