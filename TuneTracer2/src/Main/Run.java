package Main;

import java.sql.Connection;
import java.sql.SQLException;

import controller.CadastroController;
import model.dao.ConexaoSQL;
import view.TelaCadastro;

public class Run {

	public static void main(String[] args) {
		
		ConexaoSQL sq = new ConexaoSQL();
		CadastroController cadastroCon = new CadastroController(sq);
	
		try(Connection conected = sq.getConect()){
			
			TelaCadastro tela = new TelaCadastro(cadastroCon, sq);
			tela.setVisible(true);
			
		}catch(SQLException e){
			e.printStackTrace();
	
		}
	
	}
}