package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {

<<<<<<< HEAD
	private static final String URL = "jdbc:mysql://localhost:3306/tunetracer";
=======
	private static final String URL = "jdbc:mysql://localhost:3306/tune_tracer";
>>>>>>> 7e54e61dd832634c2170593260ec180afdf25d2f
	private static final String USUARIO = "root";
	private static final String SENHA = "root";
	
	private static Connection conexao;
	
	private static ConexaoSQL con;
	
	public static ConexaoSQL getInstance() {
		if (con == null) {
			con = new ConexaoSQL();
		}
		return con;
		
	}
	
	public static Connection getConect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection(URL,USUARIO,SENHA);
			System.out.println("Conexão realizada");
			
		}catch(ClassNotFoundException e) {
			throw new RuntimeException("Driver não encontrado",e);
		}catch (SQLException e) {
			System.err.println("Erro ao conectar ao Banco de Dados "+e.getMessage());
		}
		return conexao;
	}
}
