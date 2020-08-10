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
public class Medicamento implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)

	private long id;
	private String nomeMedicamento;
	@OneToMany(cascade = CascadeType.ALL)
	private List<MedicamentoPaciente> medicamentosPacientes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}
	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	public List<MedicamentoPaciente> getMedicamentosPacientes() {
		return medicamentosPacientes;
	}
	public void setMedicamentosPacientes(List<MedicamentoPaciente> medicamentosPacientes) {
		this.medicamentosPacientes = medicamentosPacientes;
	}
}
