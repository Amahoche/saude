package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco extends AbstractEntity {

	private String bairro;
	private String quarteirao;
	private String rua;
	private String avenida;
	
	/**@OneToMany(mappedBy="endereco")
	private List<Pessoa> pessoa;
	
	
	public List<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(List<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	**/
	//@OneToOne(cascade=CascadeType.ALL)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getQuarteirao() {
		return quarteirao;
	}
	public void setQuarteirao(String quarteirao) {
		this.quarteirao = quarteirao;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getAvenida() {
		return avenida;
	}
	public void setAvenida(String avenida) {
		this.avenida = avenida;
	}
	
	
}
