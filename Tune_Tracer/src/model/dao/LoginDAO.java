package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	private Connection conexao;
	
	public LoginDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public boolean verificaLogin(String email, String senha) {
		
		try {
			
		String sql = "SELECT * FROM cadastro WHERE email = ? AND senha = ?";
		
		PreparedStatement statement = conexao.prepareStatement(sql);
		
		statement.setString(1, email);
		statement.setString(2, senha);
		ResultSet resultado = statement.executeQuery();
		return resultado.next();
		
		}catch(SQLException e) {
			return false;
		}
	}
}