package net.javaguides.springboot.springsecurity.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.springsecurity.error.ResourceNotFoundException;
import net.javaguides.springboot.springsecurity.model.Funcionario;
import net.javaguides.springboot.springsecurity.model.Paciente;
import net.javaguides.springboot.springsecurity.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioEndpoint {
	
	private final FuncionarioRepository dao;
	@Autowired
	public FuncionarioEndpoint(FuncionarioRepository dao) {
		this.dao = dao;
	}
	
	@GetMapping(value="/listarFuncionarios")
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView lista() {
		ModelAndView mv= new ModelAndView("list");
		Iterable<Funcionario> funcionarios= dao.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
		
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<?> getFuncionarioById(@PathVariable("id") Long id){
		Optional<Funcionario> funcionario = dao.findById(id);
		verifyIfFuncionarioExists(id);
		return new ResponseEntity<>(funcionario, HttpStatus.OK);
	}
		
	@GetMapping(path = "/findByNome/{nome}" )
	public ResponseEntity<?> findFuncionarioByNome(@PathVariable String nome){
		return new ResponseEntity<>(dao.findByNomeIgnoreCaseContaining(nome), HttpStatus.OK);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	//public ResponseEntity<?> save(@RequestBody Student student){
	//return new ResponseEntity<>(dao.save(student), HttpStatus.OK)};
	
	public String adicionar (Funcionario funcionario) {
			dao.save(funcionario);
			return "redirect:/funcionario";
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
	public ResponseEntity<?> delete(@PathVariable Long id){
	verifyIfFuncionarioExists(id);
	dao.deleteById(id);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Funcionario funcionario){
	verifyIfFuncionarioExists(funcionario.getId());
	dao.save(funcionario);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}
	//METODO PARA VERIFICACAO DA EXISTENCIA DA PESSOA E LANCAMENTO DE ERROS!
	private void verifyIfFuncionarioExists(Long id) {
		if(dao.findById(id) == null) {
			throw new ResourceNotFoundException("Pessoa nao encontrada para o ID: "+id);
			
			}
	}

}
