package net.javaguides.springboot.springsecurity.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.springsecurity.error.ResourceNotFoundException;
import net.javaguides.springboot.springsecurity.model.Paciente;
import net.javaguides.springboot.springsecurity.repository.PacienteRepository;



@RestController
@RequestMapping("/paciente")
public class PacienteEndpoint {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	 
    private final int ROW_PER_PAGE = 5;
 
    @Autowired
	//private PacienteService ps;
	
	private final PacienteRepository dao;
	@Autowired
	public PacienteEndpoint(PacienteRepository dao) {
		this.dao = dao;
	}

	@GetMapping(value="/listarPacientes")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView lista() {
		ModelAndView mv= new ModelAndView("lista");
		Iterable<Paciente> pacientes= dao.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}
		
	/**@GetMapping(value = "/findById/{id}")
	public ResponseEntity<?> getPacienteById(@PathVariable("id") Long id){
		Optional<Paciente> paciente = dao.findById(id);
		verifyIfPacienteExists(id);
		return new ResponseEntity<>(paciente, HttpStatus.OK);
	}
		
	@GetMapping(value = "/findByNome/{nome}" )
	public ResponseEntity<?> findPacienteByNome(@PathVariable String nome){
		return new ResponseEntity<>(dao.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
	}
	**/
	 
    /**@GetMapping(value = {"/editar"})
    public String showEditContact(Model model, @PathVariable long pacientetId) {
        Paciente paciente = null;
        try {
            paciente = ps.findById(pacientetId);
        } catch (ResourceNotFoundException ex) {
            model.addAttribute("errorMessage", "Paciente nao Encontrado");
        }
        model.addAttribute("add", false);
        model.addAttribute("paciente", paciente);
        return "editarpaciente";
    }
     
    @PostMapping(value = {"/editar"})
    public String updateContact(Model model,
            @PathVariable long pacienteId,
            @ModelAttribute("paciente") Paciente paciente) {        
        try {
            paciente.setId(pacienteId);
            ps.update(paciente);
            return "redirect:/teste/" + String.valueOf(paciente.getId());
        } catch (Exception ex) {
            // log exception first, 
            // then show error
            String errorMessage = ex.getMessage();
            logger.error(errorMessage);
            model.addAttribute("errorMessage", errorMessage);
     
             model.addAttribute("add", false);
            return "editarpaciente";
        }}**/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String adicionar (Paciente paciente) {
			dao.save(paciente);
			return "dashboard";
			}
	/**@PostMapping(value="/{id}")
	//@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String  detalhesFuncionarioPost(@PathVariable("id") long id, Especialidade especialidades) {
		Optional<Funcionario> funcionario=dao.findById(id);
		especialidades.setFuncionario(funcionario);
		er.save(especialidades);
		
		return "redirect:/{id}";
	}**/
	
	@DeleteMapping
	@GetMapping(value="/deletar")
	@ResponseStatus(HttpStatus.OK)
	public String deletarPaciente( Long id){
	Optional<Paciente> paciente = dao.findById(id);
	dao.delete(paciente);
	return "redirect:/paciente/listarPacientes";
		
	}
	
/**@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String update(Paciente paciente){
	verifyIfPacienteExists(paciente.getId());
	dao.save(paciente);
	return "redirect:/paciente/listarPacientes";**/
	
	
	

}
