package model.vo;

public class FavoritosVO {
	
	private String nota;
	private String instrumento;
	
	public FavoritosVO(String nota, String instrumento) {
		this.nota = nota;
		this.instrumento = instrumento;
	}

	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public String getInstrumento() {
		return instrumento;
	}


	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	
}
