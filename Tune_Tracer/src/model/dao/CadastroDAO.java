package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.vo.CadastroVO;

public class CadastroDAO {
    private Connection conexao;

    public CadastroDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrozin(CadastroVO c) throws SQLException {
        String sql = "INSERT INTO cadastro (nome, email, senha, palavra_chave) VALUES (?, ?, ?, ?)";
        
        if (c.getNome() == null || c.getEmail() == null || c.getSenha() == null ||
        	c.getPalavra_chave() == null || c.getPalavra_chave().isEmpty() ||
            c.getNome().isEmpty() || c.getEmail().isEmpty() || c.getSenha().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campo não preenchido");
            return; // Não continua com a inserção se algum campo estiver vazio
        }
        
        try (PreparedStatement st = conexao.prepareStatement(sql)) {
            st.setString(1, c.getNome());
            st.setString(2, c.getEmail());
            st.setString(3, c.getSenha());
            st.setString(4, c.getPalavra_chave());

            st.execute();

            System.out.println("Cadastro realizado com sucesso.");
            
        } catch (SQLException e) {
            System.err.println("Erro ao fazer o cadastro de dados");
        }
    }
}
