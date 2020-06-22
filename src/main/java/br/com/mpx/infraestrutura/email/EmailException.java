package br.com.mpx.infraestrutura.email;

public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailException(String mensagem, Throwable causa) {
		super(mensagem, causa);
		// TODO Auto-generated constructor stub
	}

	public EmailException(String mensagem) {
		super(mensagem);
		// TODO Auto-generated constructor stub
	}
	

}
