package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="medicamento")
public class Medicamento extends AbstractEntity {


	private String nomeMedicamento;
	/**@ManyToOne
	private MedicamentoPaciente medicamentopaciente;

	public MedicamentoPaciente getMedicamentopaciente() {
		return medicamentopaciente;
	}

	public void setMedicamentopaciente(MedicamentoPaciente medicamentopaciente) {
		this.medicamentopaciente = medicamentopaciente;
	}
**/
	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	
}
