package net.javaguides.springboot.springsecurity.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class PreNatal extends AbstractEntity {

	private String dataInicio;
	private String descricao;
	/**@OneToMany
	private List<Paciente> paciente;
	
	public List<Paciente> getPaciente() {
		return paciente;
	}
	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}**/
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
