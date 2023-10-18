package model.vo;

public class mudarEmailVO {

	private String email_novoField;
	private String senha1Field;
	private String email_atualField;
	
	public mudarEmailVO(String email_atualField, String email_novoField) {
		this.email_atualField = email_atualField;
		this.email_novoField = email_novoField;
		this.senha1Field = senha1Field;  
	}

	public String getEmail_novoField() {
		return email_novoField;
	}

	public void setEmail_novoField(String email_novoField) {
		this.email_novoField = email_novoField;
	}
	
	public String getEmail_atualField() {
		return email_atualField;
	}

	public void setEmail_atualField(String email_atualField) {
		this.email_atualField = email_atualField;
	}
	
	
}
