package controller;

import java.sql.*;
import javax.swing.JOptionPane;
import model.bo.LoginBO;
import model.dao.ConexaoSQL;
import model.vo.LoginVO;
import view.TelaEscolhaDeInstrumento;
import view.TelaLogin;

public class LoginController {
    private ConexaoSQL sq;
    private LoginBO bo;

    public LoginController(ConexaoSQL sq) {
        this.sq = sq;
        bo = new LoginBO(sq);
    }

    public void iniciar() {
        TelaLogin telaLogin = new TelaLogin(this, sq);
        telaLogin.setVisible(true);
    }

    public void Logar(String email, String senha) {
        try (Connection connect = sq.getConect()) {
            LoginVO log = new LoginVO(email, senha);
            boolean logado = bo.Logar(log);

            if (logado) {
                JOptionPane.showMessageDialog(null, "LOGIN FEITO");
                
                    
    				TelaEscolhaDeInstrumento tei = new TelaEscolhaDeInstrumento(sq.getConect());
    				tei.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(null, "Login incorreto ou campos não preenchidos");
                 	TelaLogin tl = new TelaLogin(null, sq);
                 	tl.setVisible(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
