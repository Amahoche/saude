package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tratamento")
public class Tratamento extends AbstractEntity{

	
	 private String nome;
	 private Double valorConsulta;
	 /** @OneToMany(mappedBy = "tratamento")
	 private List<Consulta> consulta;
	@OneToMany
	 private List<Evolucao> evolucao;
	
	public List<Evolucao> getEvolucao() {
		return evolucao;
	}
	public void setEvolucao(List<Evolucao> evolucao) {
		this.evolucao = evolucao;
	}
	public List<Consulta> getConsulta() {
		return consulta;
	}
	public void setConsulta(List<Consulta> consulta) {
		this.consulta = consulta;
	}**/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorConsulta() {
		return valorConsulta;
	}
	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
}
