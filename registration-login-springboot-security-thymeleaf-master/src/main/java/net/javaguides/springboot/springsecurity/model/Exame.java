package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exame")
public class Exame extends AbstractEntity {
	
	private String nome;
	private String descricao;
	/**@OneToMany
	private List<ResultadoExame> resultadoexame;
	
	
	public List<ResultadoExame> getResultadoexame() {
		return resultadoexame;
	}
	public void setResultadoexame(List<ResultadoExame> resultadoexame) {
		this.resultadoexame = resultadoexame;
	}**/
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
