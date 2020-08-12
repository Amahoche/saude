package com.projecto.saude.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
@Validated
@Entity
@Getter
@Setter
public class Exame implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private long id;
	private String nome;
	private String descricao;
	@OneToOne(cascade = CascadeType.ALL)
	private ResultadoExame resultadoExame;
	public ResultadoExame getResultadoExame() {
		return resultadoExame;
	}
	public void setResultadoExame(ResultadoExame resultadoExame) {
		this.resultadoExame = resultadoExame;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	private Paciente pacientes;
	public Paciente getPacientes() {
		return pacientes;
	}
	public void setPacientes(Paciente pacientes) {
		this.pacientes = pacientes;
	}

}
