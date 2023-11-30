package model.bo;

import java.sql.Connection;
import java.sql.SQLException;
import model.dao.ConfigDAO;
import model.vo.mudarSenhaVO;
import model.vo.mudarNomeVO;
import model.vo.mudarEmailVO;

public class ConfigBO {
    private final ConfigDAO ConfigDAO;

    public ConfigBO(Connection conexao) {
        ConfigDAO = new ConfigDAO(conexao);
    }


    public boolean mudarSenha(mudarSenhaVO r) throws SQLException {
        if (r.getEmail3Field() == null || r.getSenha_atualField() == null || r.getNova_senhaField() == null) {
            return false;
        }

        try {
            return ConfigDAO.mudarSenha(r);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public boolean mudarNome(mudarNomeVO r) throws SQLException {
        if (r.getNome_atualField() == null || r.getEmail2Field() == null || r.getNovo_nomeField() == null) {
            return false;
        }

        try {
            return ConfigDAO.mudarNome(r);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public boolean mudarEmail(mudarEmailVO r) throws SQLException {
        if (r.getEmail_atualField() == null || r.getEmail_novoField() == null) {
            return false;
        }

        try {
            return ConfigDAO.mudarEmail(r);
        } catch (SQLException e) {
            throw e;
        }
    }
}
