package com.projecto.saude.service;


import java.util.List;
import java.util.Optional;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AbstractPageRequest;
//import org.springframework.boot.web.servlet.server.Session;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.projecto.saude.Models.Paciente;
import com.projecto.saude.Repository.PacienteFiltro;
import com.projecto.saude.Repository.PacienteRepository;


@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	private PacienteRepository dao;
	//FIND ALL
	@Override
	public List<Paciente> getAllPacientes(){
		return dao.findAll();
	}
//SAVE
	@Override
	public void savePaciente(Paciente paciente) {
		this.dao.save(paciente);
		
	}
//UPDATE
	@Override
	public Paciente getPacienteById(long id) {
		Optional<Paciente> optional = dao.findById(id);
		Paciente paciente = null;
		if(optional.isPresent()) {
			paciente = optional.get();
		}
		else {
			throw new RuntimeException("Paciente nao Encontrado para o id :: " +id);
		}
		return paciente;
	}
	
	//DELETE
	@Override
	public void deletePacienteById(long id) {
		
		
		this.dao.deleteById(id);
		
	}
	@Override
	public Page<Paciente> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return dao.findAll(pageable);
	}

	@Override
	public Page<Paciente> filtrar(PacienteFiltro filtro, java.awt.print.Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Paciente.class);

		int paginaAtual = ((Pageable) pageable).getPageNumber();
		int totalRegistrosPorPagina = ((Pageable) pageable).getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);

		Sort sort = ((Pageable) pageable).getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			criteria.addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}
		adicionarFiltro(filtro, criteria);
		// new PageImpl<>(criteria.list(), pageable, total(filtro));
	}	
	private Long total(PacienteFiltro filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Paciente.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}
	
	
	private void adicionarFiltro(PacienteFiltro filtro, Criteria criteria) {
		if (!StringUtils.isEmpty(filtro.getNome())) {
			criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
	}
		
	}
	
	
	
	
	


