package net.javaguides.springboot.springsecurity.model;

import javax.persistence.Entity;

@Entity
public class ExamePaciente extends AbstractEntity{
	
	
	private String dataExame;

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
	}

	
}
