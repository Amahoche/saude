package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
public class Funcionario extends AbstractEntity{

	private String nome;
	private String apelido;
	private String email;
	private String documento;
	private String num_doc;
	private String cargo;
	private Double salario;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNum_doc() {
		return num_doc;
	}
	public void setNum_doc(String num_doc) {
		this.num_doc = num_doc;
	}

	/**@OneToMany
	private List<Agenda> agenda;
	public List<Agenda> getAgenda() {
		return agenda;
	}
	public void setAgenda(List<Agenda> agenda) {
		this.agenda = agenda;
	}**/
	/**@ManyToOne
	private Especialidade especialidade;
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}**/
	/**@JoinTable(name="funcionario",
	          joinColumns={@JoinColumn(name="funcionario_id",  
	           referencedColumnName="id")},  
	          inverseJoinColumns={@JoinColumn(name="pessoa_id",   
	           referencedColumnName="id")})  
	@OneToOne(mappedBy="pessoa", cascade=CascadeType.ALL)
**/
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
