package controller;

import java.sql.SQLException;
import model.bo.RecuperarSenhaBO;
<<<<<<< HEAD
=======
import model.dao.ConexaoSQL;
>>>>>>> 7e54e61dd832634c2170593260ec180afdf25d2f
import model.vo.RecuperarSenhaVO;
import java.sql.Connection; // Importe a classe Connection aqui

public class RecuperarSenhaController {
    private RecuperarSenhaBO recuperarSenhaBO;
    private Connection conexao; // Adicione uma referência à conexão aqui

    public RecuperarSenhaController(Connection conexao) {
        this.conexao = conexao;
        recuperarSenhaBO = new RecuperarSenhaBO(conexao); // Passe a conexão para o construtor de RecuperarSenhaBO
    }

<<<<<<< HEAD
    public boolean processarRecuperacaoSenha(String email, String palavraChave, String novaSenha) {
=======
	public boolean processarRecuperacaoSenha(String email, String palavraChave, String novaSenha) {
>>>>>>> 7e54e61dd832634c2170593260ec180afdf25d2f
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
