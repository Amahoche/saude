package com.projecto.saude.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.projecto.saude.Models.Funcionario;
import com.projecto.saude.Repository.FuncionarioRepository;
import com.projecto.saude.service.FuncionarioService;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioEndpoint {
	
	@Autowired
    private FuncionarioService fs;
  
    @Autowired
	private FuncionarioRepository dao;
	
	
//LIST ALL

	@GetMapping(value="/listarFuncionarios")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView lista() {
		ModelAndView mv= new ModelAndView("list");
		Iterable<Funcionario> funcionarios= dao.findAll();
		mv.addObject("funcionarios", funcionarios);
        return mv;
		
	}

    //
    @GetMapping(value="/NovoFuncionario")
 	@ResponseStatus(HttpStatus.OK)
	public String NovoPaciente(Model model) {
		Funcionario funcionario = new Funcionario();
		model.addAttribute("funcionario", funcionario);
		return "worker";
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (Funcionario funcionario) {
			dao.save(funcionario);
			return "dashboard";
			}
    //SAVE FUNCIONARIO
	/** @PostMapping("/adicionarPaciente")
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (@ModelAttribute("paciente") Paciente paciente) {
    	ps.savePaciente(paciente);
			return "redirect:/dashboard";
			}**/
    //UPDATE
    
    @GetMapping(value="/updateFuncionario/{id}")
 	@ResponseStatus(HttpStatus.OK)
	public String editar(@PathVariable (value = "id") long id, Model model) {
		
		//GET PACIENTE FROM SERVICE
		Funcionario funcionario = fs.getFuncionarioById(id);
		//SET PACIENTE AS MODEL ATTRIBUTE TO PRE-POPULATE FORM
		model.addAttribute("funcionario", funcionario);
		return "redirect:/updateFuncionario";
	}
//DELETE
    
    @GetMapping(value="/deleteFuncionario/{id}")
    @ResponseStatus(HttpStatus.OK)
	public String deleteFuuncionario(@PathVariable (value = "id") long id) {
    	
    	this.fs.deleteFuncionarioById(id);
    	return "redirect:/paciente/listarFuncionarios";
}
   //PAGINATION METHOD 
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
    
    /**@GetMapping("id")
    public ModelAndView detalhesFuncionario(@PathVariable(value = "id") long id) {
    	Optional<Funcionario> funcionario = dao.findById(id);
    	ModelAndView mv = new ModelAndView("detalhesFuncionario");
    	mv.addObject("funcionario", funcionario);
    	return mv;
    }**/
     

}
