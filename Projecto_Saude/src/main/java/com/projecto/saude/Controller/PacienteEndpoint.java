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
import com.projecto.saude.Models.Paciente;
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
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (Paciente paciente) {
			dao.save(paciente);
			return "dashboard";
			}
    //SAVE PACIENTE
	/** @PostMapping("/adicionarPaciente")
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (@ModelAttribute("paciente") Paciente paciente) {
    	ps.savePaciente(paciente);
			return "redirect:/dashboard";
			}**/
    //UPDATE
    
    @GetMapping(value="/updatePaciente/{id}")
	public String editar(@PathVariable (value = "id") long id, Model model) {
		
		//GET PACIENTE FROM SERVICE
		Paciente paciente = ps.getPacienteById(id);
		//SET PACIENTE AS MODEL ATTRIBUTE TO PRE-POPULATE FORM
		model.addAttribute("paciente", paciente);
		return "redirect:/editarPaciente";
	}
//DELETE
    
    @GetMapping(value="/deletePaciente/{id}")
	public String deletePaciente(@PathVariable (value = "id") long id) {
    	
    	this.ps.deletePacienteById(id);
    	return "redirect:/paciente/listarPacientes";
}
   //PAGINATION METHOD 
    @GetMapping(value="/page/{pageNo}")
    public String findPaginated(@PathVariable (value= "pageNo") int pageNo, Model model) {
    	int pageSize = 5;
    	Page<Paciente> page = ps.findPaginated(pageNo, pageSize);
    	List<Paciente> listPacientes = page.getContent();
    	model.addAttribute("currentPage", pageNo);
    	model.addAttribute("totalPage", page.getTotalPages());
    	model.addAttribute("totalItems", page.getTotalElements());
    	model.addAttribute("listPacientes", listPacientes);
    
    	return "paciente/listarPacientes";
    }
     
    
}

