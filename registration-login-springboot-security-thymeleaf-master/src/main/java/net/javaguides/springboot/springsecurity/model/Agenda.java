package net.javaguides.springboot.springsecurity.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Agenda extends AbstractEntity {
	
	
	private String dataConsulta;
	private String dataMarcada;
	
	//private Funcionario funcionario;
	public String getDataConsulta() {
		return dataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	public String getDataMarcada() {
		return dataMarcada;
	}
	public void setDataMarcada(String dataMarcada) {
		this.dataMarcada = dataMarcada;
	}
	
	
	
	
}
