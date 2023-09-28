package controller;

import java.sql.Connection;
import java.sql.SQLException;
import model.bo.FavoritosBO;
import model.dao.ConexaoSQL;
import model.vo.FavoritosVO;

public class FavoritosController {
		private ConexaoSQL sq;
		private FavoritosBO favoBO;
		
		public FavoritosController(ConexaoSQL sq) {
			this.sq = sq;
			favoBO = new FavoritosBO(sq);
		}
		
		public void favoritarNow (String nota, String instrumento) {
			
			try (Connection conect = sq.getConect()){
				
				FavoritosVO fas = new FavoritosVO(nota, instrumento);
				fas.setNota(nota);
				fas.setInstrumento(instrumento);
				
				favoBO.favorit(fas);
				
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}

