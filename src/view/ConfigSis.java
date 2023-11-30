package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import controller.ConfigController;
import model.dao.ConexaoSQL;
import model.dao.ConfigDAO;

public class ConfigSis extends JFrame {

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	Color fundo = new Color(255, 245, 239);
	JTabbedPane tabbedPane = new JTabbedPane();
	private JTextField nomeField;
	private JTextField emailField;
	private JTextField senha_atualField;
	private JTextField nova_senhaField;
	private JTextField nome_atualField;
	private JTextField email2Field;
	private JTextField novo_nomeField;
	private JTextField email_atualField;
	private JTextField email_novoField;
	private JTextField email3Field;
	private static ConfigController ConfigCon;
	private static ConexaoSQL sq;
	private static Connection conexao;

	public ConfigSis(Connection conexao) {
		
        this.conexao = conexao;
		//this.ConfigCon = ConfigCon;
		//this.sq = sq;
		ConfigDAO configDao = new ConfigDAO(sq.getConect());
		ConfigCon = new ConfigController(conexao);

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(fundo);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
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

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 463);
		getContentPane().add(panel);
		panel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 766, 463);

		JLabel label2 = new JLabel("panel two", SwingConstants.CENTER);
		JPanel panel2 = new JPanel();
		tabbedPane.addTab("Alterar senha", null, panel2, "Second Panel");
		panel2.setLayout(null);

		senha_atualField = new JTextField();
		senha_atualField.setBounds(323, 153, 96, 19);
		panel2.add(senha_atualField);
		senha_atualField.setColumns(10);

		JLabel lblSenhaAtual = new JLabel("Senha atual");
		lblSenhaAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenhaAtual.setBounds(323, 124, 96, 19);
		panel2.add(lblSenhaAtual);

		nova_senhaField = new JTextField();
		nova_senhaField.setBounds(323, 219, 96, 19);
		panel2.add(nova_senhaField);
		nova_senhaField.setColumns(10);

		JLabel lblNovaSenha = new JLabel("Nova senha");
		lblNovaSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovaSenha.setBounds(323, 196, 96, 13);
		panel2.add(lblNovaSenha);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(320, 279, 85, 21);
		panel2.add(btnSalvar);
		
		btnSalvar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String email = email3Field.getText();
				String senhaAtual = senha_atualField.getText();
				String novaSenha = nova_senhaField.getText();
				
				ConfigController controller = new ConfigController(conexao);

				boolean sucesso = controller.processarMudarSenha(email, senhaAtual, novaSenha);
				if (sucesso) {
					JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao alterar a senha. Verifique seus dados.");
				}
			}
		});

		JLabel lblEmail3 = new JLabel("Email");
		lblEmail3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail3.setBounds(323, 72, 45, 13);
		panel2.add(lblEmail3);

		email3Field = new JTextField();
		email3Field.setBounds(323, 95, 96, 19);
		panel2.add(email3Field);
		email3Field.setColumns(10);

		JLabel label3 = new JLabel("panel three");
		JPanel panel3 = new JPanel();
		tabbedPane.addTab("Alterar nome", null, panel3, "Third Panel");
		panel3.setLayout(null);

		nome_atualField = new JTextField();
		nome_atualField.setBounds(311, 98, 96, 19);
		panel3.add(nome_atualField);
		nome_atualField.setColumns(10);

		JLabel lblNomeAtual = new JLabel("Nome atual");
		lblNomeAtual.setBounds(311, 71, 72, 17);
		lblNomeAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel3.add(lblNomeAtual);

		JLabel lblEmail2 = new JLabel("Email");
		lblEmail2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail2.setBounds(311, 127, 45, 13);
		panel3.add(lblEmail2);

		email2Field = new JTextField();
		email2Field.setBounds(311, 152, 96, 19);
		panel3.add(email2Field);
		email2Field.setColumns(10);

		JLabel lblNovoNome = new JLabel("Novo nome");
		lblNovoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNovoNome.setBounds(311, 181, 85, 17);
		panel3.add(lblNovoNome);

		novo_nomeField = new JTextField();
		novo_nomeField.setBounds(311, 208, 96, 19);
		panel3.add(novo_nomeField);
		novo_nomeField.setColumns(10);

		JButton btnAlterar3 = new JButton("Alterar");
		btnAlterar3.setBounds(322, 269, 85, 21);
		panel3.add(btnAlterar3);
		
		btnAlterar3.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String nomeAtual = nome_atualField.getText();
		    	String email = email2Field.getText();
				String novoNome = novo_nomeField.getText();
				
				ConfigController controller1 = new ConfigController(conexao);

				boolean sucesso = controller1.processarMudarNome(nomeAtual, email, novoNome);
				if (sucesso) {
					JOptionPane.showMessageDialog(null, "Nome alterado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao alterar o nome. Verifique seus dados.");
				}
			}
		});

		JLabel label4 = new JLabel("panel three");
		JPanel panel4 = new JPanel();
		tabbedPane.addTab("Alterar email", null, panel4, "Third Panel");
		panel4.setLayout(null);

		email_atualField = new JTextField();
		email_atualField.setBounds(288, 153, 96, 19);
		panel4.add(email_atualField);
		email_atualField.setColumns(10);

		JLabel lblEmailAtual = new JLabel("Email atual");
		lblEmailAtual.setBounds(288, 126, 69, 17);
		lblEmailAtual.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel4.add(lblEmailAtual);

		JLabel lblEmailNovo = new JLabel("Email novo");
		lblEmailNovo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailNovo.setBounds(288, 236, 96, 19);
		panel4.add(lblEmailNovo);

		email_novoField = new JTextField();
		email_novoField.setBounds(288, 265, 96, 19);
		panel4.add(email_novoField);
		email_novoField.setColumns(10);

		JButton btnAlterar4 = new JButton("Alterar");
		btnAlterar4.setBounds(299, 296, 85, 21);
		panel4.add(btnAlterar4);
		
		btnAlterar4.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String emailAtual = email_atualField.getText();
				String emailNovo = email_novoField.getText();
				
				ConfigController controller2 = new ConfigController(conexao);

				boolean sucesso = controller2.processarMudarEmail(emailAtual, emailNovo);
				if (sucesso) {
					JOptionPane.showMessageDialog(null, "Email alterado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Falha ao alterar o email. Verifique seus dados.");
				}
			}
		});

		panel.add(tabbedPane);

		setVisible(true);
	}

	 public static void main(String[] args) {
		 ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
		 Connection conexao = conexaoSQL.getConect(); // Obtenha a conexão

			// Crie uma instância de RecuperarSenha passando a conexão
			new ConfigSis(conexao);
	 }
}