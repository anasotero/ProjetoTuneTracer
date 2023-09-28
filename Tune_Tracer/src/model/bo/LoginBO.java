package model.bo;

import java.sql.SQLException;

import model.dao.ConexaoSQL;
import model.dao.LoginDAO;
import model.vo.LoginVO;

public class LoginBO {
	
	private LoginDAO login;

	public LoginBO(ConexaoSQL sq) {
		login = new LoginDAO(sq.getConect());
	}

	public boolean Logar(LoginVO log) {
		try {
			if (log.getEmail() == null || log.getEmail().isEmpty() ||
				log.getSenha() == null || log.getSenha().isEmpty()) {
				return false; // Verificação básica de campos vazios
			}
			else
			return login.verificaLogin(log.getEmail(), log.getSenha()); // Verifica credenciais no banco de dados
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
