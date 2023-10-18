package controller;

import java.sql.SQLException;
import model.bo.RecuperarSenhaBO;
import model.dao.ConexaoSQL;
import model.vo.RecuperarSenhaVO;
import java.sql.Connection; // Importe a classe Connection aqui

public class RecuperarSenhaController {
    private RecuperarSenhaBO recuperarSenhaBO;
    private Connection conexao;

    public RecuperarSenhaController(Connection conexao) {
        this.conexao = conexao;
        recuperarSenhaBO = new RecuperarSenhaBO(conexao);
    }

	public boolean processarRecuperacaoSenha(String email, String palavraChave, String novaSenha) {
        RecuperarSenhaVO recuperarSenhaVO = new RecuperarSenhaVO(email, palavraChave, novaSenha);

        try {
            return recuperarSenhaBO.alterarSenha(recuperarSenhaVO);
        } catch (SQLException e) {
            System.err.println("Erro");
            e.printStackTrace();
            return false;
        }
    }
}
