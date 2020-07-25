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
//@Getter
//@Setter
public class Consulta implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
		Consulta other = (Consulta) obj;
		if (id != other.id)
			return false;
		return true;
	}
	private String consulta;
	private String evolucao;
	private String materialUtil;
	private Double valorMaterial;
	private Double valorTotal;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getConsulta() {
		return consulta;
	}
	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	public String getEvolucao() {
		return evolucao;
	}
	public void setEvolucao(String evolucao) {
		this.evolucao = evolucao;
	}
	public String getMaterialUtil() {
		return materialUtil;
	}
	public void setMaterialUtil(String materialUtil) {
		this.materialUtil = materialUtil;
	}
	public Double getValorMaterial() {
		return valorMaterial;
	}
	public void setValorMaterial(Double valorMaterial) {
		this.valorMaterial = valorMaterial;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
