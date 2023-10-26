package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.mudarNomeVO;
import model.vo.mudarSenhaVO;
import model.vo.mudarEmailVO;

public class configDAO {

    private Connection connection;
    private ConexaoSQL sq;

    public configDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean mudarSenha(mudarSenhaVO r) throws SQLException {
        String sql = "UPDATE cadastro SET senha = ? WHERE email = ? AND senha = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, r.getNova_senhaField());
            statement.setString(2, r.getEmail3Field());
            statement.setString(3, r.getSenha_atualField());

            int rowsUpdated = statement.executeUpdate();

            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public boolean mudarNome(mudarNomeVO r) throws SQLException {
        String sql2 = "UPDATE cadastro SET nome = ? WHERE email = ? AND nome = ?";

        try (PreparedStatement st2 = connection.prepareStatement(sql2)) {
            st2.setString(1, r.getNovo_nomeField());
            st2.setString(2, r.getEmail2Field());
            st2.setString(3, r.getNome_atualField());
            
            int rowsUpdated = st2.executeUpdate();
            
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public boolean mudarEmail(mudarEmailVO r) throws SQLException {
        String sql3 = "UPDATE cadastro SET email = ? WHERE email = ?";

        try (PreparedStatement st3 = connection.prepareStatement(sql3)) {
            st3.setString(1, r.getEmail_novoField());
            st3.setString(2, r.getEmail_atualField());
            
            int rowsUpdated = st3.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
