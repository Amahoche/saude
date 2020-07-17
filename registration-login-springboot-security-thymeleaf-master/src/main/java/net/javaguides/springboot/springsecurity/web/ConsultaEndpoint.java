/**package net.javaguides.springboot.springsecurity.web;


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

import net.javaguides.springboot.springsecurity.error.ResourceNotFoundException;
import net.javaguides.springboot.springsecurity.model.Consulta;
import net.javaguides.springboot.springsecurity.repository.ConsultaRepository;


@RestController
@RequestMapping("/consulta")
public class ConsultaEndpoint {
	
	private final ConsultaRepository dao;
	@Autowired
	public ConsultaEndpoint(ConsultaRepository dao) {
		this.dao = dao;
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public String listar(){
		dao.findAll();
		return"consulta";
	}
		
	@GetMapping(path = "/findById/{id}")
	public ResponseEntity<?> getCidadeyId(@PathVariable("id") Long id){
		Optional<Consulta> consulta = dao.findById(id);
		verifyIfConsultaExists(id);
		return new ResponseEntity<>(consulta, HttpStatus.OK);
	}
		
	@GetMapping(path = "/findByconsulta/{consulta}" )
	public ResponseEntity<?> findConsultaByconsulta(@PathVariable String consulta){
		return new ResponseEntity<>(dao.findByconsultaIgnoreCaseContaining(consulta), HttpStatus.OK);
	}
	
	@PostMapping
	//public ResponseEntity<?> save(@RequestBody Student student){
	//return new ResponseEntity<>(dao.save(student), HttpStatus.OK)};
	
	public String adicionar(Consulta consulta) {
			dao.save(consulta);
			return "redirect:/consulta";
			}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
	verifyIfConsultaExists(id);
	dao.deleteById(id);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Consulta consulta){
	verifyIfConsultaExists(consulta.getId());
	dao.save(consulta);
	return new ResponseEntity<>( HttpStatus.OK);
		
	}
	//METODO PARA VERIFICACAO DA EXISTENCIA DA PESSOA E LANCAMENTO DE ERROS!
	private void verifyIfConsultaExists(Long id) {
		if(dao.findById(id) == null) {
			throw new ResourceNotFoundException("Consulta nao encontrada para o ID: "+id);
			
			}
	}


}
**/