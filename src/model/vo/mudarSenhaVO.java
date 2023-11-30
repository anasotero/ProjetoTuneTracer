package model.vo;

public class mudarSenhaVO {

	private String senha_atualField;
	private String nova_senhaField;
	private String email3Field;

	public mudarSenhaVO(String email3Field, String senha_atualField, String nova_senhaField) {
		this.nova_senhaField = nova_senhaField;
		this.email3Field = email3Field;
		this.senha_atualField = senha_atualField;
	}

	public String getSenha_atualField() {
		return senha_atualField;
	}

	public void setSenha_atualField(String senha_atualField) {
		this.senha_atualField = senha_atualField;
	}

	public String getNova_senhaField() {
		return nova_senhaField;
	}

	public void setNova_senhaField(String nova_senhaField) {
		this.nova_senhaField = nova_senhaField;
	}

	public String getEmail3Field() {
		return email3Field;
	}

	public void setEmail3Field(String email3Field) {
		this.email3Field = email3Field;
	}
	
	

}