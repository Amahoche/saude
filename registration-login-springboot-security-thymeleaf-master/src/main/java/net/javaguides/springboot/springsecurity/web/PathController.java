package net.javaguides.springboot.springsecurity.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {
	
	
	   @GetMapping(value="/pacientes")
	    public String listapacientes() {
	        return "lista.html";
	    }
	    

	}
	


