package controller;

import java.sql.SQLException;
import model.bo.configBO;
import model.dao.ConexaoSQL;
import model.vo.mudarSenhaVO;
import model.vo.mudarNomeVO;
import model.vo.mudarEmailVO;
import java.sql.Connection;

public class configController {
	private configBO ConfigBO;
	private Connection conexao;

	public configController(Connection conexao) {
		this.conexao = conexao;
		ConfigBO = new configBO(conexao);
	}

	public boolean processarMudarSenha(String email, String senhaAtual, String novaSenha) {
		mudarSenhaVO ConfigVO = new mudarSenhaVO(email, senhaAtual, novaSenha);

		try {
			return ConfigBO.mudarSenha(ConfigVO);
		} catch (SQLException e) {
			System.err.println("Erro");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean processarMudarNome(String nome_atualField, String email2Field, String novo_nomeField) {
		mudarNomeVO ConfigVO2 = new mudarNomeVO(nome_atualField, email2Field, novo_nomeField);

		try {
			return ConfigBO.mudarNome(ConfigVO2);
		} catch (SQLException e) {
			System.err.println("Erro");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean processarMudarEmail(String email_atualField, String email_novoField) {
		mudarEmailVO ConfigVO3 = new mudarEmailVO(email_atualField, email_novoField);

		try {
			return ConfigBO.mudarEmail(ConfigVO3);
		} catch (SQLException e) {
			System.err.println("Erro");
			e.printStackTrace();
			return false;
		}
	}

}
