package model.bo;

import java.sql.Connection;
import java.sql.SQLException;
import model.dao.RecuperarSenhaDAO;
import model.vo.RecuperarSenhaVO;

public class RecuperarSenhaBO {
    private final RecuperarSenhaDAO recuperarSenhaDAO;

    public RecuperarSenhaBO(Connection conexao) {
        recuperarSenhaDAO = new RecuperarSenhaDAO(conexao);
    }


    public boolean alterarSenha(RecuperarSenhaVO r) throws SQLException {
        if (r.getEmail() == null || r.getPalavra_chave() == null || r.getSenha_nova() == null) {
            return false;
        }

        try {
            return recuperarSenhaDAO.alterarSenha(r);
        } catch (SQLException e) {
            // Trate a exceção aqui ou relance para que o controlador possa tratar
            throw e;
        }
    }
}
