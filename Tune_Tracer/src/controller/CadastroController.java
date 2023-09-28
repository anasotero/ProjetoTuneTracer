package controller;

import java.sql.Connection;
import java.sql.SQLException;

import model.bo.CadastroBO;
import model.dao.ConexaoSQL;
import model.vo.CadastroVO;

public class CadastroController {
	
	private ConexaoSQL sq;
	private CadastroBO cadastrobo;
	
	public CadastroController(ConexaoSQL sq) {
		this.sq = sq;
		cadastrobo = new CadastroBO(sq);
	}
	
	public void cadastrar (String nome, String email, String senha, String palavra_chave) {
		
		try (Connection conect = sq.getConect()){
			CadastroVO cadas = new CadastroVO();
			cadas.setNome(nome);
			cadas.setEmail(email);
			cadas.setSenha(senha);
			cadas.setPalavra_chave(palavra_chave);
			
			cadastrobo.cadastrar(cadas);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
}
