package com.projecto.saude.envio;

import java.util.List;

public class Mensagem {
	
	private String remetente;
	private List<String> destinatario;
	private String assunto;
	private String corpo;
	
	
	public String getRemetente() {
		return remetente;
	}


	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}


	public List<String> getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(List<String> destinatario) {
		this.destinatario = destinatario;
	}


	public String getAssunto() {
		return assunto;
	}


	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getCorpo() {
		return corpo;
	}


	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public Mensagem(String remetente, List<String> destinatario, String assunto, String corpo) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.corpo = corpo;
	}
	

}
