package br.com.mpx.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mpx.dominio.service.EmailService;
import br.com.mpx.dominio.service.EmailService.Mensagem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private EmailService envioEmail;
	
	@GetMapping("/enviar-email")
	public String enviarEmail() {
		Cliente cliente = new Cliente("Aqui é a mensagem 1", "Aqui é a mensagem 2", "Comprar Agora", "Obrigado.", "Alex Pereira Maranhão");
		
		Mensagem mensagem = Mensagem.builder()
				.assunto("Bem-vindo")
				.corpo("template-email.html")
				.variavel("cliente", cliente)
				.destinatario("alexpereira365@gmail.com")
				.build();
		
		envioEmail.enviar(mensagem);
		
		return "Email enviado";
		
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	class Cliente {
		private String mensagem1;
		private String mensagem2;
		private String callToAction;
		private String despedida;
		private String nome;
		
	}
	

}
