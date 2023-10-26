package model.vo;

public class mudarNomeVO {
	
	private String novo_nomeField;
	private String email2Field;
	private String nome_atualField;
	
	public mudarNomeVO(String nome_atualField, String email2Field, String novo_nomeField) {
		this.email2Field = email2Field;
		this.nome_atualField = nome_atualField;
		this.novo_nomeField = novo_nomeField;
	}

	public String getNovo_nomeField() {
		return novo_nomeField;
	}

	public void setNovo_nomeField(String novo_nomeField) {
		this.novo_nomeField = novo_nomeField;
	}

	public String getEmail2Field() {
		return email2Field;
	}

	public void setEmail2Field(String email2Field) {
		this.email2Field = email2Field;
	}

	public String getNome_atualField() {
		return nome_atualField;
	}

	public void setNome_atualField(String nome_atualField) {
		this.nome_atualField = nome_atualField;
	}

	
}
