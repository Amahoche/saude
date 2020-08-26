package com.projecto.saude.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
@Validated
@Entity
@Getter
@Setter
public class Especialidade implements Serializable{
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	private String nome;
	@OneToMany(mappedBy= "funcionario", cascade=CascadeType.ALL)
	public List<Funcionario> getFuncionarios() {
	return getFuncionarios();
	}

}
