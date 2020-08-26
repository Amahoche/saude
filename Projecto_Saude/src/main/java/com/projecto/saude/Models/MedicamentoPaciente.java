package com.projecto.saude.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Validated
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentoPaciente implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")

	private long id;
	private String inicio;
	private String dosagem;
	private String fim;
	private String posologia;
}
