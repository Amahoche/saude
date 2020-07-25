package com.projecto.saude.Models;
/**package com.projecto.saude.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	@NotBlank
	private String nome;
	private String apelido;
	@Email
	private String email;
	private String documento;
	private String numDoc;
	private Calendar dataNasc;
	
	
	
	
}**/
