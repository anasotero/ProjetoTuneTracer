package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.vo.RecuperarSenhaVO;

public class RecuperarSenhaDAO {
    private Connection conect;

    public RecuperarSenhaDAO(Connection conect) {
        this.conect = conect;
    }

    public boolean alterarSenha(RecuperarSenhaVO r) throws SQLException {
        String sql = "UPDATE cadastro SET senha = ? WHERE email = ? AND palavra_chave = ?";

        try (PreparedStatement st = conect.prepareStatement(sql)) {
            st.setString(1, r.getSenha_nova());
            st.setString(2, r.getEmail());
            st.setString(3, r.getPalavra_chave());

            int rowsUpdated = st.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; 
        }
    }
}
