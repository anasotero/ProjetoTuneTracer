package model.bo;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.dao.FavoritosInsertDAO;
import model.dao.ConexaoSQL;
import model.vo.FavoritosVO;

public class FavoritosBO {
		
	    private FavoritosInsertDAO dao;

	    public FavoritosBO(ConexaoSQL sq) {
	        dao = new FavoritosInsertDAO(sq.getConect());
	    }

	    public void favorit(FavoritosVO fa) throws SQLException {

	        try {
	            dao.favoritar(fa);
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
