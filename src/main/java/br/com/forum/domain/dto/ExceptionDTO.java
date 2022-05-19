package br.com.forum.domain.dto;

public class ExceptionDTO {
	
	private String campo;
	private String erro;
	
	public ExceptionDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
