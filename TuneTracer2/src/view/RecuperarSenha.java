package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import controller.RecuperarSenhaController;
import model.dao.ConexaoSQL;
import model.vo.RecuperarSenhaVO;
import controller.RecuperarSenhaController;

public class RecuperarSenha extends JFrame {
	private JTextField emailField;
	private JTextField palavra_chaveField;
	private JTextField nova_senhaField;

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");

	public RecuperarSenha(Connection conexao) { // Receba a conexão como argumento
		setTitle("Recuperar Senha");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 583);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());

		getContentPane().setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(270, 130, 91, 24);
		getContentPane().add(lblEmail);

		emailField = new JTextField();
		emailField.setBounds(270, 166, 170, 30);
		getContentPane().add(emailField);
		emailField.setColumns(10);

		JLabel lblPalavraChave = new JLabel("Cor favorita");
		lblPalavraChave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPalavraChave.setBounds(270, 206, 275, 33);
		getContentPane().add(lblPalavraChave);

		palavra_chaveField = new JTextField();
		palavra_chaveField.setBounds(270, 249, 170, 24);
		getContentPane().add(palavra_chaveField);
		palavra_chaveField.setColumns(10);

		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaSenha.setBounds(272, 297, 104, 17);
		getContentPane().add(lblNovaSenha);

		nova_senhaField = new JTextField();
		nova_senhaField.setBounds(270, 324, 170, 24);
		getContentPane().add(nova_senhaField);
		nova_senhaField.setColumns(10);

		JButton btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarSenha.setBounds(205, 382, 136, 38);
		getContentPane().add(btnAlterarSenha);
		
		btnAlterarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = emailField.getText();
				String palavraChave = palavra_chaveField.getText();
				String novaSenha = nova_senhaField.getText();

				// Chame o controlador para processar a recuperação de senha
				RecuperarSenhaController controller = new RecuperarSenhaController(conexao);

				boolean sucesso = controller.processarRecuperacaoSenha(email, palavraChave, novaSenha);
				if (sucesso) {
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao alterar a senha. Verifique seus dados.");
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(366, 384, 128, 34);
		getContentPane().add(btnCancelar);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) throws SQLException {
		ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
		Connection conexao = conexaoSQL.getConect(); // Obtenha a conexão

		// Crie uma instância de RecuperarSenha passando a conexão
		new RecuperarSenha(conexao);
	}
}
