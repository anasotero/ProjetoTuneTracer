package model.bo;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.dao.CadastroDAO;
import model.dao.ConexaoSQL;
import model.vo.CadastroVO;

public class CadastroBO {
	private CadastroDAO dao;

	public CadastroBO(ConexaoSQL sq) {
		dao = new CadastroDAO(sq.getConect());
	}

	public void cadastrar(CadastroVO cadas) throws SQLException {

		try {
			if (cadas.getNome() == null || cadas.getNome().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O nome do usuário não pode estar vazio");
				return;
			}

			if (cadas.getEmail() == null || cadas.getEmail().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O email do usuário não pode estar vazio");
				return;
			}

			if (cadas.getSenha() == null || cadas.getSenha().isEmpty()) {
				JOptionPane.showMessageDialog(null, "A senha não pode estar vazia");
				return;
			}
			
			if (cadas.getPalavra_chave() == null || cadas.getPalavra_chave().isEmpty()) {
				JOptionPane.showMessageDialog(null, "A palavra chave de recuperação não pode estar vazia");
				return;
			}

			dao.cadastrozin(cadas);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
