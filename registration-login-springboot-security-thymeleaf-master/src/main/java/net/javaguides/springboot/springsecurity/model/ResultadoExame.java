package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="resultadoexame")
public class ResultadoExame extends AbstractEntity {
	
	
	private String resultado;
	/**private Exame exame;

	@OneToOne(mappedBy="exame")
	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}**/

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
