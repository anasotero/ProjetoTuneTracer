package Main;

import java.sql.Connection;
import java.sql.SQLException;

import controller.CadastroController;
import controller.LoginController;
import model.dao.ConexaoSQL;
import view.SplashScreenExample;
import view.TelaCadastro;

public class Run {

	public static void main(String[] args) {
		
		ConexaoSQL sq = new ConexaoSQL();
		CadastroController cadastroCon = new CadastroController(sq);
		LoginController logcon = new LoginController(sq);
		
		try(Connection conected = sq.getConect()){
			
			TelaCadastro tela = new TelaCadastro(cadastroCon, sq, logcon);
			tela.setVisible(true);
			
		}catch(SQLException e){
			e.printStackTrace();
	
		}
	
	}
}