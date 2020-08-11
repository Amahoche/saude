/**package com.projecto.saude.email;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SendMail {
	public static void main(String[]args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SendMail.class.getPackage().getName());
		applicationContext.close();
		
		System.out.println("Fim");
		
	}

}**/
