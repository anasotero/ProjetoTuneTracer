package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import controller.LoginController;
import controller.Metodos;
import model.dao.ConexaoSQL;

public class Afinador1 extends JFrame {

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon afina  = new ImageIcon("imagens/Afinador.png");
	ImageIcon afinaa = new ImageIcon(afina.getImage().getScaledInstance(780, 500, Image.SCALE_DEFAULT));
	private JLabel afinaaa = new JLabel(afinaa);
	
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance();
	Connection conexao = conexaoSQL.getConect();
	static ConexaoSQL sq = new ConexaoSQL();
	static LoginController logcon = new LoginController(sq);

	public Afinador1() {
		setTitle("Afinador");
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 441);
		getContentPane().add(panel);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		setBackground(new Color(255, 204, 153));
		setVisible(true);
		setLocationRelativeTo(null);
		
		JLabel afinador = new JLabel(afinaa);
		panel.add(afinador);
		
		/////////////////////////////////////

		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);

		JMenu btnMizonanMenu = new JMenu("Menu");
		btnMizonanMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMizonanMenu);

		JMenuItem setting = new JMenuItem("Configurações");
		setting.setBackground(new Color(255, 145, 77));
		setting.setForeground(new Color(128, 128, 128));
		btnMizonanMenu.add(setting);
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
		btnMizonanMenu.add(retornar);
		setVisible(true);

		retornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaEscolhaDeInstrumento TEI = new TelaEscolhaDeInstrumento();
				TEI.setVisible(true);
				dispose();
			}
		});

		/////////////////////////////////////////

		JButton btnMizona = new JButton("E");
		btnMizona.setBackground(new Color(255, 147, 74));
		btnMizona.setForeground(new Color(255, 255, 255));
		btnMizona.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMizona.setBounds(131, 324, 53, 45);
		setVisible(true);
		panel.setLayout(null);
		panel.add(btnMizona);
		panel.setComponentZOrder(btnMizona, 0);

		btnMizona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaMizona();
			}
		});

		JButton btnLa = new JButton("A");
		btnLa.setBackground(new Color(255, 147, 74));
		btnLa.setForeground(new Color(255, 255, 255));
		btnLa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLa.setBounds(131, 233, 53, 45);
		setVisible(true);
		panel.add(btnLa);
		panel.setComponentZOrder(btnLa, 0);

		btnLa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaLa();
			}
		});

		JButton btnRe = new JButton("D");
		btnRe.setBackground(new Color(255, 147, 74));
		btnRe.setForeground(new Color(255, 255, 255));
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRe.setBounds(131, 141, 55, 45);
		setVisible(true);
		panel.add(btnRe);
		panel.setComponentZOrder(btnRe, 0);

		btnRe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaRe();
			}
		});

		JButton btnSol = new JButton("G");
		btnSol.setBackground(new Color(255, 147, 74));
		btnSol.setForeground(new Color(255, 255, 255));
		btnSol.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSol.setBounds(574, 141, 55, 45);
		setVisible(true);
		panel.add(btnSol);
		panel.setComponentZOrder(btnSol, 0);

		btnSol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaSol();
			}
		});

		JButton btnSi = new JButton("B");
		btnSi.setBackground(new Color(255, 147, 74));
		btnSi.setForeground(new Color(255, 255, 255));
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSi.setBounds(576, 233, 53, 45);
		setVisible(true);
		panel.add(btnSi);
		panel.setComponentZOrder(btnSi, 0);

		btnSi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaSi();
			}
		});

		JButton btnMizinha = new JButton("E");
		btnMizinha.setBackground(new Color(255, 147, 74));
		btnMizinha.setForeground(new Color(255, 255, 255));
		btnMizinha.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnMizinha.setBounds(576, 324, 53, 45);
		setVisible(true);
		panel.add(btnMizinha);
		panel.setComponentZOrder(btnMizinha, 0);

		btnMizinha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaMizinha();
			}
		});

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Afinador1();
		});

	}
}
