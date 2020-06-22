package br.com.mpx.infraestrutura.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import br.com.mpx.core.email.EmailProperties;
import br.com.mpx.dominio.service.EmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class ProducaoEmailService implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmailProperties emailProperties;

	@Autowired
	private Configuration fremarkerConfiguration;

	@Override
	public void enviar(Mensagem mensagem) {
		try {
			MimeMessage mimeMessage = criarMimeMessage(mensagem);

			javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			throw new EmailException("Não foi possível enviar e-mail", e);
		}
	}

	protected MimeMessage criarMimeMessage(Mensagem mensagem) throws MessagingException {
		try {

			String corpoEmail = this.processarMensagem(mensagem);

			MimeMessage mimeMessage = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

			helper.setFrom(emailProperties.getRemetente());
			helper.setTo(mensagem.getDestinatarios().toArray(new String[0]));
			helper.setSubject(mensagem.getAssunto());
			helper.setText(corpoEmail, true);

			return mimeMessage;

		} catch (Exception e) {
			throw new EmailException("Não foi possível enviar e-mail", e);
		}

	}

	protected String processarMensagem(Mensagem mensagem) {

		try {
			Template template = fremarkerConfiguration.getTemplate(mensagem.getCorpo());

			System.out.println(">>>>>> " + mensagem.getVariaveis().get("cliente"));
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, mensagem.getVariaveis().get("cliente"));

		} catch (Exception e) {
			throw new EmailException("Não foi possível montar o template do e-mail", e);
		}

	}

}