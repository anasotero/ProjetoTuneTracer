package model.vo;

public class RecuperarSenhaVO {
	
	private String email;
	private String palavra_chave;
	private String senha_nova;
	
	public RecuperarSenhaVO() {}
	
	public RecuperarSenhaVO(String email, String palavra_chave, String senha_nova) {
		this.email = email;
		this.palavra_chave = palavra_chave;
		this.senha_nova = senha_nova;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPalavra_chave() {
		return palavra_chave;
	}

	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}

	public String getSenha_nova() {
		return senha_nova;
	}

	public void setSenha_nova(String senha_nova) {
		this.senha_nova = senha_nova;
	}


}
