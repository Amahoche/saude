package net.javaguides.springboot.springsecurity.web;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
 
	
	//private PacienteService ps;
	
	private final PacienteRepository dao;
	@Autowired
	public PacienteEndpoint(PacienteRepository dao) {
		this.dao = dao;
	}
	
	
	//@GetMapping
	//@ResponseStatus(HttpStatus.OK)
	/**public String listar(){
		dao.findAll();
		return "tester";
	}**/
	/** @GetMapping(value = "/pacientes")
   public String getPacientes(Model model,
            @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Paciente> pacientes = ps.findAll(pageNumber, ROW_PER_PAGE);
     
       /** ModelAndView mv= new ModelAndView("lista");
		Iterable<Paciente> paciente= dao.findAll();
		mv.addObject("pacientes", pacientes);
		
        long count = ps.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "listaup
    }**/
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView lista() {
		ModelAndView mv= new ModelAndView("lista");
		Iterable<Paciente> pacientes= dao.findAll();
		mv.addObject("pacientes", pacientes);
		return mv;
	}
		
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<?> getPacienteById(@PathVariable("id") Long id){
		Optional<Paciente> paciente = dao.findById(id);
		verifyIfPacienteExists(id);
		return new ResponseEntity<>(paciente, HttpStatus.OK);
	}
		
	@GetMapping(value = "/findByNome/{nome}" )
	public ResponseEntity<?> findPacienteByNome(@PathVariable String nome){
		return new ResponseEntity<>(dao.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//public ResponseEntity<?> save(@RequestBody Student student){
	//return new ResponseEntity<>(dao.save(student), HttpStatus.OK)};
	
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
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String delete(@PathVariable Long id){
	verifyIfPacienteExists(id);
	dao.deleteById(id);
	return "pacienteLista";
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public String update(Paciente paciente){
	verifyIfPacienteExists(paciente.getId());
	dao.save(paciente);
	return "pacienteEdtitar";
		
	}
	//METODO PARA VERIFICACAO DA EXISTENCIA DA PESSOA E LANCAMENTO DE ERROS!
	private void verifyIfPacienteExists(Long id) {
		if(dao.findById(id) == null) {
			throw new ResourceNotFoundException("Pessoa nao encontrada para o ID: "+id);
			
			}
	}

}
