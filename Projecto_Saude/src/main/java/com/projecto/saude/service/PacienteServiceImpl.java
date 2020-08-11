package com.projecto.saude.service;


import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
	public void filtrar(PacienteFiltro filtro, java.awt.print.Pageable pageable) {
	CriteriaBuilder builder = Paciente.getCriteriaBuilder();

	javax.persistence.criteria.CriteriaQuery<Paciente> criteria = builder.createQuery( Paciente.class );
		int paginaAtual = ((Pageable) pageable).getPageNumber();
		int totalRegistrosPorPagina = ((Pageable) pageable).getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;

		((Criteria) criteria).setFirstResult(primeiroRegistro);
		((Criteria) criteria).setMaxResults(totalRegistrosPorPagina);

		Sort sort = ((Pageable) pageable).getSort();
		if (sort != null) {
			Sort.Order order = sort.iterator().next();
			String property = order.getProperty();
			((Criteria) criteria).addOrder(order.isAscending() ? Order.asc(property) : Order.desc(property));
		}
		adicionarFiltro(filtro, (CriteriaQuery) criteria);
		// new PageImpl<>(criteria.list(), pageable, total(filtro));
	}	
	@SuppressWarnings("unused")
	private Long total(PacienteFiltro filtro) {
		CriteriaBuilder builder = Paciente.getCriteriaBuilder();

		javax.persistence.criteria.CriteriaQuery<Paciente> criteria = builder.createQuery( Paciente.class );
		adicionarFiltro(filtro, (CriteriaQuery) criteria);
		((Criteria) criteria).setProjection(Projections.rowCount());
		return (Long) ((Criteria) criteria).uniqueResult();
	}
	
	
	private void adicionarFiltro(PacienteFiltro filtro, CriteriaQuery criteria) {
		if (!StringUtils.isEmpty(filtro.getNome())) {
			((Criteria) criteria).add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
	}
		
	}
	
	
	
	
	


