package com.projecto.saude.Models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class DataAcesso implements Serializable {
	public static final long serialVersionUID=1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	private long id;
	private String acesso;

}
