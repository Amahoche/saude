package com.projecto.saude.Models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;

import com.projecto.saude.Repository.PacienteFiltro;

import lombok.Getter;
import lombok.Setter;

@Validated
@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Paciente")
public class Paciente extends Pessoa{

	
	private String conjuge;
	private String telfConjuge;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Medicamento> medicamentos;
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	@OneToMany(cascade = CascadeType.ALL)
	private List<Exame> exames;
	public List<Exame> getExames() {
		return exames;
	}
	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "pacientes")
			
	private Set<Consulta> consultas;
	
	public Set<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(Set<Consulta> consultas) {
		this.consultas = consultas;
	}
	public String getConjuge() {
		return conjuge;
	}
	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}
	public String getTelfConjuge() {
		return telfConjuge;
	}
	public void setTelfConjuge(String telfConjuge) {
		this.telfConjuge = telfConjuge;
	}
	
	
}
