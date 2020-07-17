/**package net.javaguides.springboot.springsecurity.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.springsecurity.model.Consulta;
import net.javaguides.springboot.springsecurity.repository.TesteRepository;

@RestController
@RequestMapping("/consulta")

public class TesteEndpoint {
	
	@Autowired
	private TesteRepository tr;
	
	@PostMapping
	public String adicionar(Consulta consulta) {
		tr.save(consulta);
		return "/consulta";
	}


}
**/