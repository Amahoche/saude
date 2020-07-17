package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade extends AbstractEntity{
	
	private String nome;
	/**@OneToMany(targetEntity = Funcionario.class, mappedBy ="especialidade",cascade = CascadeType.ALL)
	
	private List<Funcionario> funcionario;

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}**/

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
