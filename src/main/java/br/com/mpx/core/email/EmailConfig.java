package br.com.mpx.core.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.mpx.dominio.service.EmailService;
import br.com.mpx.infraestrutura.email.ProducaoEmailService;
import br.com.mpx.infraestrutura.email.TestesEmailService;

@Configuration
public class EmailConfig {
	
	@Autowired 
	private EmailProperties emailProperties;
	
	@Bean
	public EmailService emailService() {
		switch (emailProperties.getImplementacao()) {
		case TESTES:
			return new TestesEmailService();

		case PRODUCAO:
			return new ProducaoEmailService();
		default:
			return null;
		}
	}
	

}
