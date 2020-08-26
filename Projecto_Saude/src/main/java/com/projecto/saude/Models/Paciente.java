package com.projecto.saude.Models;


import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Validated
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue(value = "Paciente")
public class Paciente extends Pessoa{

	private static final long serialVersionUID = 1L;
	private String conjuge;
	private String telfConjuge;
	@ManyToOne
	@JoinColumn(name="cidade_id", insertable=false, updatable=false)
	private Cidade cidade;
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
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
	@OneToMany
	private List<Exame> exames;
	
	
}
