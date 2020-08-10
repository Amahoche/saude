package com.projecto.saude.Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Funcionario")
public class Funcionario extends Pessoa{

	
	private String cargo;
	private Double salario;
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
