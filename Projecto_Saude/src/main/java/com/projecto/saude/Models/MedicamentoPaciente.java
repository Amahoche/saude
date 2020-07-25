package com.projecto.saude.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;
@Validated
@Entity
@Getter
@Setter
public class MedicamentoPaciente implements Serializable {
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
		MedicamentoPaciente other = (MedicamentoPaciente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	private String inicio;
	private String dosagem;
	private String fim;
}