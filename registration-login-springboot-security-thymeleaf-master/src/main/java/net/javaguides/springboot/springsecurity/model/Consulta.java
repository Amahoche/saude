package net.javaguides.springboot.springsecurity.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="consulta")
public class Consulta extends AbstractEntity {
	private String nome;
	private String evolucao;
	private String materialUtil;
	private String valorMaterial;
	private String valorTotal;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getValorMaterial() {
		return valorMaterial;
	}
	public void setValorMaterial(String valorMaterial) {
		this.valorMaterial = valorMaterial;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	/**@OneToMany(mappedBy = "consulta")
	private List<Paciente> paciente;
	@ManyToOne
	private Tratamento tratamento;
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}
	

	public List<Paciente> getPaciente() {
		return paciente;
	}
	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}**/
	

}
