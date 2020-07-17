package net.javaguides.springboot.springsecurity.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class DataAcesso extends AbstractEntity {
	
	private String acesso;
	/**@OneToMany
	private List<Pessoa> pessoa;

	public List<Pessoa> getPessoa() {
		return pessoa;
	}

	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}**/

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

}
