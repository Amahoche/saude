package net.javaguides.springboot.springsecurity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import org.springframework.util.StringUtils;
import net.javaguides.springboot.springsecurity.error.BadResourceException;
import net.javaguides.springboot.springsecurity.error.ResourceNotFoundException;
import net.javaguides.springboot.springsecurity.error.ResourceAlreadyExistsException;
import net.javaguides.springboot.springsecurity.model.Paciente;
import net.javaguides.springboot.springsecurity.repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	private PacienteRepository dao;
	 private boolean existsById(Long id) {
	        return dao.existsById(id);
	    }
	    
	    public Paciente findById(Long id) throws ResourceNotFoundException {
	        Paciente paciente = dao.findById(id).orElse(null);
	        if (paciente==null) {
	            throw new ResourceNotFoundException("Paciente Nao encontrado para o ID: " + id);
	        }
	        else return paciente;
	    }
	    
	    public List<Paciente> findAll(int pageNumber, int rowPerPage) {
	        List<Paciente> pacientes = new ArrayList<>();
	        Iterable<Long> sortedByIdAsc = (Iterable<Long>) PageRequest.of(pageNumber - 1, rowPerPage, 
	                Sort.by("id").ascending());
	        dao.findAllById(sortedByIdAsc).forEach(pacientes::add);
	        return pacientes;
	    }
	    
	    public Paciente save(Paciente paciente) throws BadResourceException, ResourceAccessException {
	        if (!StringUtils.isEmpty(paciente.getNome())) {
	            if (paciente.getId() != null && existsById(paciente.getId())) { 
	                throw new ResourceAccessException("Paciente com o ID: " + paciente.getId() +
	                        " Ja existe");
	            }
	            return dao.save(paciente);
	        }
	        else {
	            BadResourceException exc = new BadResourceException(null);
	          //  exc.addErrorMessage("Paciente esta nulo vazio");
	            throw exc;
	        }
	    }
	    
	    public void update(Paciente paciente) 
	            throws BadResourceException, ResourceNotFoundException {
	        if (!StringUtils.isEmpty(paciente.getNome())) {
	            if (!existsById(paciente.getId())) {
	                throw new ResourceNotFoundException("Nao foi possivel salvar o Paciente para o ID: " + paciente.getId());
	            }
	            dao.save(paciente);
	        }
	        else {
	            BadResourceException exc = new BadResourceException("Falha ao salvar Paciente");
	            //exc.addErrorMessage("Paciente esta nulo vazio");
	            throw exc;
	        }
	    }
	    
	    public void deleteById(Long id) throws ResourceNotFoundException {
	        if (!existsById(id)) { 
	            throw new ResourceNotFoundException("Paciente Nao encontrado para o ID: " + id);
	        }
	        else {
	            dao.deleteById(id);
	        }
	    }
	    
	    public Long count() {
	        return dao.count();
	    }
	}



