package net.javaguides.springboot.springsecurity.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Paciente extends AbstractEntity {
	private String nome;
	private String apelido;
	private String email;
	private String documento;
	private String num_doc;
	private String conjuge;
	
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
	private String telfConjuge;
	/**@ManyToOne
	private PreNatal prenatal;
	public PreNatal getPrenatal() {
		return prenatal;
	}
	public void setPrenatal(PreNatal prenatal) {
		this.prenatal = prenatal;
	}
	public List<MedicamentoPaciente> getMedicamentopaciente() {
		return medicamentopaciente;
	}
	public void setMedicamentopaciente(List<MedicamentoPaciente> medicamentopaciente) {
		this.medicamentopaciente = medicamentopaciente;
	}
	@OneToMany
	private List<MedicamentoPaciente>medicamentopaciente;
	@ManyToOne
	private Consulta consulta;
	
@OneToOne(mappedBy="pessoa", cascade=CascadeType.ALL)

	public Consulta getConsulta() {
		return consulta;
	}
	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}***/
	public String getConjuge() {
		return conjuge;
	}
	public void setConjuge(String conjuge) {
		this.conjuge = conjuge;
	}
	public String getTelfConjuge() {
		return telfConjuge;
	}
	public void setTelfConjuge(String telfConjuge) {
		this.telfConjuge = telfConjuge;
	}
	
	

	
	
	
	
}
