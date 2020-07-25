package com.projecto.saude.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidade other = (Especialidade) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private String nome;
	@OneToMany
	private List<Funcionario> funcionarios;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFuncionario(Optional<Funcionario> funcionario) {
		// TODO Auto-generated method stub
		
	}

}
