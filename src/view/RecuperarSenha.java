package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;
import java.sql.SQLException;

import controller.Metodos;
import controller.RecuperarSenhaController;
import model.dao.ConexaoSQL;
import model.vo.RecuperarSenhaVO;
import controller.RecuperarSenhaController;

public class RecuperarSenha extends JFrame {

	private JTextField emailField;
	private JTextField palavra_chaveField;
	private JTextField nova_senhaField;

	// instanciações
	private Color fundo = new Color(255, 147, 74);
	private Color cinzenta = new Color(195,195,195);
	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private ImageIcon cenarioNR = new ImageIcon("imagens/RecSenha.png");
	ImageIcon cenario = new ImageIcon(cenarioNR.getImage().getScaledInstance(780, 500
			, Image.SCALE_DEFAULT));
	private JLabel lblCenario = new JLabel(cenario);

	public RecuperarSenha(Connection conexao) {

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(fundo);
		getContentPane().setLayout(null);
		Metodos.verificaTema((JComponent) getContentPane());
		
		// configuração do menu

		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);

		JMenu btnMenu = new JMenu("Menu");
		btnMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMenu);

		JMenuItem setting = new JMenuItem("Configurações");
		setting.setBackground(new Color(255, 145, 77));
		setting.setForeground(new Color(128, 128, 128));
		btnMenu.add(setting);
		setVisible(true);

		setting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConfigSis CO = new ConfigSis(conexao);
				CO.setVisible(true);
				dispose();
			}
		});

		JMenuItem retornar = new JMenuItem("Retornar");
		retornar.setMnemonic('R');
		retornar.setBackground(new Color(255, 255, 255));
		retornar.setForeground(new Color(255, 128, 0));
		btnMenu.add(retornar);
		setVisible(true);

		retornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaEscolhaDeInstrumento TDI = new TelaEscolhaDeInstrumento();
				TDI.setVisible(true);
				dispose();
			}
		});

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(363, 60, 91, 24);
		getContentPane().add(lblEmail);

		emailField = new JTextField("digite seu email aqui");
		emailField.setForeground(cinzenta);
		emailField.setBounds(270, 106, 234, 30);
		getContentPane().add(emailField);
		emailField.setColumns(10);
		emailField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emailField.setText("");
			}
		});

		JLabel lblPalavraChave = new JLabel("Cor favorita");
		lblPalavraChave.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPalavraChave.setBounds(340, 154, 275, 33);
		getContentPane().add(lblPalavraChave);

		palavra_chaveField = new JTextField("digite sua cor favorita aqui");
		palavra_chaveField.setForeground(cinzenta);
		palavra_chaveField.setBounds(270, 197, 234, 30);
		getContentPane().add(palavra_chaveField);
		palavra_chaveField.setColumns(10);
		palavra_chaveField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				palavra_chaveField.setText("");
			}
		});

		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNovaSenha.setBounds(340, 262, 104, 17);
		getContentPane().add(lblNovaSenha);

		nova_senhaField = new JTextField("digite sua nova senha aqui");
		nova_senhaField.setForeground(cinzenta);
		nova_senhaField.setBounds(270, 298, 234, 30);
		getContentPane().add(nova_senhaField);
		nova_senhaField.setColumns(10);
		nova_senhaField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nova_senhaField.setText("");
			}
		});

		JButton btnAlterarSenha = new JButton("Alterar senha");
		btnAlterarSenha.setBackground(new Color(255, 255, 255));
		btnAlterarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAlterarSenha.setBounds(205, 356, 136, 38);
		getContentPane().add(btnAlterarSenha);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(426, 355, 128, 40);
		getContentPane().add(btnCancelar);

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
	
		lblCenario.setLayout(null);
		lblCenario.setVisible(true);
		lblCenario.setBounds(0, -13, 766, 476);
		getContentPane().add(lblCenario);


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
