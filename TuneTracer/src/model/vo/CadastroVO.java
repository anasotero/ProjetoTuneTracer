package model.vo;

public class CadastroVO {

	private String nome;
	private String email;
	private String senha;
	private String palavra_chave;
	
	public CadastroVO(String nome, String email, String senha, String palavra_chave) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.palavra_chave = palavra_chave;
	}
	
	public CadastroVO() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPalavra_chave() {
		return palavra_chave;
	}

	public void setPalavra_chave(String palavra_chave) {
		this.palavra_chave = palavra_chave;
	}
	
	
}
