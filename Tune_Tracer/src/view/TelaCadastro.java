package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import controller.CadastroController;
import controller.LoginController;
import model.dao.ConexaoSQL;
import model.vo.CadastroVO;

@SuppressWarnings("serial")
public class TelaCadastro extends JFrame {

	private ConexaoSQL sq;
	private CadastroController cadastroCon;
	private LoginController logcon;
	private JPanel contentpane;
	private JTextField nomeField, emailField;
	private JPasswordField passwordField;
	private JButton lblLogar;

	ImageIcon fundo = new ImageIcon(getClass().getResource("TuneTracer_b" + "ackground.png"));
	ImageIcon icon = new ImageIcon(fundo.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon ocarina = new ImageIcon(getClass().getResource("ocarina.png"));
	private JTextField palavra_chaveField;

	// construindo a janela
	public TelaCadastro(CadastroController cadastroCon, ConexaoSQL sq) {

		this.cadastroCon = cadastroCon;
		this.sq = sq;

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 583);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());

		contentpane = new JPanel();
		contentpane.setBackground(new Color(255, 147, 74));
		contentpane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentpane);
		contentpane.setLayout(null);

		// criando o painel

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(366, 0, 400, 546);
		panel_1.setBackground(Color.WHITE);
		contentpane.add(panel_1);
		panel_1.setLayout(null);

		// primeiro label (texto)

		JLabel lblLabel1 = new JLabel("CADASTRO");
		lblLabel1.setBounds(79, 38, 252, 42);
		lblLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblLabel1);
		lblLabel1.setLabelFor(panel_1);
		lblLabel1.setFont(new Font("Arial", Font.BOLD, 36));

		// criando o segundo label (texto)

		JLabel lblLabel2 = new JLabel("Nome de usuário");
		lblLabel2.setBounds(79, 112, 113, 17);
		lblLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblLabel2);

		nomeField = new JTextField();
		nomeField.setBounds(79, 139, 243, 27);
		nomeField.setBackground(new Color(255, 255, 255));
		panel_1.add(nomeField);

		JLabel lblLabel3 = new JLabel("Senha");
		lblLabel3.setBounds(79, 260, 38, 17);
		lblLabel3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblLabel3);

		passwordField = new JPasswordField();
		passwordField.setBounds(79, 287, 243, 27);
		panel_1.add(passwordField);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cadastrar();

				/*
				 * TelaEscolhaDeInstrumento TEDI = new TelaEscolhaDeInstrumento();
				 * TEDI.setVisible(true); dispose();
				 */
			}

		});
		btnCadastrar.setMnemonic('C');
		btnCadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(new Color(255, 147, 74));
		btnCadastrar.setBounds(79, 427, 243, 42);
		panel_1.add(btnCadastrar);

		JLabel lblConta = new JLabel("Já tem uma conta?");
		lblConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConta.setBounds(79, 479, 122, 27);
		panel_1.add(lblConta);

		lblLogar = new JButton("Logar-se");
		lblLogar.setBackground(Color.WHITE);
		lblLogar.setForeground(new Color(30, 144, 255));
		lblLogar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLogar.setBounds(186, 483, 100, 19);
		lblLogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaLogin TL = new TelaLogin(logcon, sq);
				TL.setVisible(true);
				dispose();

			}

		});
		panel_1.add(lblLogar);

		JLabel lblLabel4 = new JLabel("E-mail");
		lblLabel4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLabel4.setBounds(79, 192, 45, 13);
		panel_1.add(lblLabel4);

		emailField = new JTextField();
		emailField.setBounds(79, 215, 243, 27);
		panel_1.add(emailField);
		emailField.setColumns(10);
		
		
		JLabel lblPalavraChave = new JLabel("Pergunta: Qual sua cor favorita?");
		lblPalavraChave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPalavraChave.setBounds(79, 334, 243, 27);
		panel_1.add(lblPalavraChave);
		
		palavra_chaveField = new JTextField();
		palavra_chaveField.setBounds(79, 371, 243, 27);
		panel_1.add(palavra_chaveField);
		palavra_chaveField.setColumns(10);

		JLabel TuneTracer = new JLabel(icon);
		TuneTracer.setLabelFor(contentpane);
		TuneTracer.setBounds(26, 107, 322, 348);
		contentpane.add(TuneTracer);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void cadastrar() {
		String nome = nomeField.getText();
		String email = emailField.getText();
		String senha = new String(passwordField.getPassword());
		String palavra_chave = palavra_chaveField.getText();

		try (Connection conected = sq.getConect()) {

			// Chamar o método cadastrar somente se os campos não estiverem vazios
			if (!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !palavra_chave.isEmpty()) {
				cadastroCon.cadastrar(nome, email, senha, palavra_chave);
				JOptionPane.showMessageDialog(this, "Sucesso no cadastro ");
				dispose();
				new TelaLogin(logcon, sq);
			} else {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erro no cadastro " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
