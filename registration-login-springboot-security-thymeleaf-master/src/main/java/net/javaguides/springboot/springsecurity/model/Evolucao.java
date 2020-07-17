package net.javaguides.springboot.springsecurity.model;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evolucao")
public class Evolucao extends AbstractEntity {
	
	private String dataInicio;
	private String dataFim;
	private String problema;
	private String procedimentos;
	/**@ManyToOne
	private Tratamento tratamento;
	
	
	public Tratamento getTratamento() {
		return tratamento;
	}
	public void setTratamento(Tratamento tratamento) {
		this.tratamento = tratamento;
	}**/
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getProblema() {
		return problema;
	}
	public void setProblema(String problema) {
		this.problema = problema;
	}
	public String getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(String procedimentos) {
		this.procedimentos = procedimentos;
	}
	
}
