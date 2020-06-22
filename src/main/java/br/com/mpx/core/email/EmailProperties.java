package br.com.mpx.core.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Validated
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "saneago.email")
public class EmailProperties {
	
	private Implementacao implementacao = Implementacao.TESTES;
	
	@NonNull
	private String remetente;
	
	private String nome;
	
	private EmailTeste teste = new EmailTeste();	
	
	public enum Implementacao{
		PRODUCAO, TESTES
	}
	
	@Getter
	@Setter
	public class EmailTeste {
		private String destinatario;
	}

}
