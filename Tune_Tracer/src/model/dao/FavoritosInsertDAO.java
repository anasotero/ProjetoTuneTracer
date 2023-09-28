package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.vo.FavoritosVO;

public class FavoritosInsertDAO {
	
	    private Connection conexao;

	    public FavoritosInsertDAO(Connection conexao) {
	    	this.conexao = conexao;
	        ConexaoSQL sq;
	            }

	    public void favoritar(FavoritosVO c) throws SQLException {
	        String sql = "INSERT INTO favoritos (nota, instrumento) VALUES (?, ?)";
	        
	        try (PreparedStatement st = conexao.prepareStatement(sql)) {
	        	
	            st.setString(1, c.getNota());
	            st.setString(2, c.getInstrumento());
	            st.execute();

	            System.out.println("Favoritado");
	            
	        } catch (SQLException e) {
	        	
	            System.err.println("Não favoritado");
	        }
	        
	        
	    }
	    
	    public void desfavoritar(FavoritosVO c) throws SQLException {
	        String sql = "delete from favoritos where nota ='C' and instrumento = 'Violão';";
	        
	        try (PreparedStatement st = conexao.prepareStatement(sql)) {
	     
	            st.executeUpdate();

	            System.out.println("Desfavoritado");
	            
	        } catch (SQLException e) {
	        	
	            System.err.println("ainda favoritado");
	        }
	        
	        
	    }
	    
	    
	    
	    
	}
