package model.dao;

import java.sql.*;
import model.vo.RecuperarSenhaVO;

public class RecuperarSenhaDAO {
	
	private Connection conect;
	
	public RecuperarSenhaDAO(Connection conect) {
		
		this.conect = conect;
		
	}
	
	public boolean AlterarSenha(RecuperarSenhaVO r) throws SQLException {
		String sql = "UPDATE cadastro SET senha = ? WHERE email = ? AND palavra_chave = ?";
		
		try(PreparedStatement st = conect.prepareStatement(sql)) {
			
			st.setString(1, r.getSenha_nova());
			st.setString(2, r.getEmail());
			st.setString(3, r.getPalavra_chave());
			
			st.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			System.err.println("Erro na alteração da senha");
		} catch (Exception e) {
			System.err.println("Erro");
		}
		
		return false;
		
	}
	
}
