package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.CadastroController;
import controller.LoginController;
import controller.Metodos;
import model.dao.ConexaoSQL;

@SuppressWarnings("serial")
public class TelaLogin extends JFrame {

	private CadastroController cadascon;
	private ConexaoSQL sq;
	private LoginController logcon;
	private JPanel contentpane;
	private JTextField EmailTextField;
	private JPasswordField passwordField;
	private JButton btnButton, lblCadastro;
	private JCheckBox CbMostrarSenha;

	ImageIcon fundo = new ImageIcon("imagens/TuneTracer_background.png");
	ImageIcon icon = new ImageIcon(fundo.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");

	// construindo a janela
	public TelaLogin(LoginController logcon, ConexaoSQL sq) {
		this.sq = sq;
		this.logcon = new LoginController(sq);

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());

		contentpane = new JPanel();
		contentpane.setBackground(new Color(255, 147, 74));
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentpane);
		contentpane.setLayout(null);

		// criando o painel

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(390, 0, 376, 463);
		panel_1.setBackground(Color.WHITE);
		contentpane.add(panel_1);
		panel_1.setLayout(null);

		// primeiro label (texto)

		JLabel lblLabel1 = new JLabel("LOGIN");
		lblLabel1.setBounds(127, 59, 113, 42);
		lblLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblLabel1);
		lblLabel1.setLabelFor(panel_1);
		lblLabel1.setFont(new Font("Arial", Font.BOLD, 36));

		// criando o segundo label (texto)

		JLabel lblLabel2 = new JLabel("E-mail");
		lblLabel2.setBounds(63, 135, 113, 17);
		lblLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblLabel2);

		EmailTextField = new JTextField();
		EmailTextField.setBounds(63, 162, 243, 27);
		EmailTextField.setBackground(new Color(255, 255, 255));
		panel_1.add(EmailTextField);

		JLabel lblLabel3 = new JLabel("Senha");
		lblLabel3.setBounds(63, 211, 38, 17);
		lblLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblLabel3);

		passwordField = new JPasswordField();
		passwordField.setBounds(63, 238, 243, 27);
		panel_1.add(passwordField);

		btnButton = new JButton("Entrar");
		btnButton.setMnemonic('E');
		btnButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnButton.setForeground(Color.BLACK);
		btnButton.setBackground(new Color(255, 147, 74));
		btnButton.setBounds(63, 315, 243, 42);
		panel_1.add(btnButton);
		btnButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Logar();
				dispose();
			}

		});

		JLabel lblConta = new JLabel("Não tem uma conta?");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConta.setBounds(63, 367, 122, 27);
		panel_1.add(lblConta);

		lblCadastro = new JButton("Cadastre-se");
		lblCadastro.setBackground(Color.WHITE);
		lblCadastro.setForeground(new Color(30, 144, 255));
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCadastro.setBounds(180, 371, 100, 19);
		lblCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaCadastro TC = new TelaCadastro(cadascon, sq);
				TC.setVisible(true);
				dispose();

			}

		});
		panel_1.add(lblCadastro);

		CbMostrarSenha = new JCheckBox("Mostrar senha");
		CbMostrarSenha.setFont(new Font("Tahoma", Font.PLAIN, 9));
		CbMostrarSenha.setBackground(new Color(255, 255, 255));
		CbMostrarSenha.setBounds(61, 282, 122, 22);
		panel_1.add(CbMostrarSenha);

		// evento da checkbox de mostrar senha

		CbMostrarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();
				passwordField.setEchoChar(cb.isSelected() ? '\0' : '*');
			}
		});

		JCheckBox cbManterSessao = new JCheckBox("Manter sessão");
		cbManterSessao.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cbManterSessao.setBackground(Color.WHITE);
		cbManterSessao.setBounds(213, 283, 93, 21);
		panel_1.add(cbManterSessao);

		cbManterSessao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbManterSessao.isSelected() == true)
					try {
						Metodos.manterSessaoAtivado(sq.getConect());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				else {
					try {
						Metodos.manterSessaoDesativado(sq.getConect());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JLabel TuneTracer = new JLabel(icon);
		TuneTracer.setLabelFor(contentpane);
		TuneTracer.setBounds(28, 46, 322, 348);
		contentpane.add(TuneTracer);

		setLocationRelativeTo(null);
		setVisible(true);

	}

	private void Logar() {
		String email = EmailTextField.getText();
		String senha = new String(passwordField.getPassword());

		try (Connection connected = sq.getConect()) {
			logcon.Logar(email, senha); // Chamar o método Logar no LoginController
			// Resto do código...
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erro no login " + e.getMessage(), "Erro ", JOptionPane.ERROR_MESSAGE);
		}
	}
}