package view;

<<<<<<< HEAD
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import controller.LoginController;
import controller.Metodos;
import model.dao.ConexaoSQL;

public class Afinador extends JFrame {

=======
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.LoginController;
import controller.Metodos;
import model.dao.ConexaoSQL;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Afinador extends JFrame{
	
	private JLabel Sair;
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon afina  = new ImageIcon("imagens/Afinador.png");
	ImageIcon afinaa = new ImageIcon(afina.getImage().getScaledInstance(780, 500, Image.SCALE_DEFAULT));
	private JLabel afinaaa = new JLabel(afinaa);
	
<<<<<<< HEAD
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance();
	Connection conexao = conexaoSQL.getConect();
	static ConexaoSQL sq = new ConexaoSQL();
	static LoginController logcon = new LoginController(sq);

=======
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // ObtnMizonaenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect(); 
	static ConexaoSQL sq = new ConexaoSQL();
	static LoginController logcon = new LoginController(sq);
	
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
	public Afinador() {
		setTitle("Afinador");
		setResizable(false);
		getContentPane().setLayout(null);
<<<<<<< HEAD

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 441);
		getContentPane().add(panel);
=======
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		setBackground(new Color(255, 204, 153));
		setVisible(true);
		setLocationRelativeTo(null);
		
<<<<<<< HEAD
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
		setting.setFont(new Font("Arial", Font.BOLD, 14));
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
		retornar.setFont(new Font("Arial", Font.BOLD, 14));
=======
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(1, 125, 720, 480);
		panel.setVisible(true);
		panel.setLayout(null);
		JLabel afinador = new JLabel(afinaa);
		setContentPane(afinador);
		
		/////////////////////////////////////
		
		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);
		
		JMenu btnMizonanMenu = new JMenu("Menu");
		btnMizonanMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMizonanMenu);
		
		JMenuItem setting = new JMenuItem("Configurações");
		setting.setBackground(new Color(255, 145, 77));
		setting.setForeground(new Color(255, 255, 255));
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
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
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
<<<<<<< HEAD
		});

		/////////////////////////////////////////

=======
		});		
		
		/////////////////////////////////////////
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnMizona = new JButton("E");
		btnMizona.setBackground(new Color(255, 147, 74));
		btnMizona.setForeground(new Color(255, 255, 255));
		btnMizona.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnMizona.setBounds(131, 324, 53, 45);
		setVisible(true);
		panel.setLayout(null);
		panel.add(btnMizona);
		panel.setComponentZOrder(btnMizona, 0);

=======
		btnMizona.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnMizona);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnMizona.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaMizona();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnLa = new JButton("A");
		btnLa.setBackground(new Color(255, 147, 74));
		btnLa.setForeground(new Color(255, 255, 255));
		btnLa.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnLa.setBounds(131, 233, 53, 45);
		setVisible(true);
		panel.add(btnLa);
		panel.setComponentZOrder(btnLa, 0);

=======
		btnLa.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnLa);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnLa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaLa();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnRe = new JButton("D");
		btnRe.setBackground(new Color(255, 147, 74));
		btnRe.setForeground(new Color(255, 255, 255));
		btnRe.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnRe.setBounds(131, 141, 55, 45);
		setVisible(true);
		panel.add(btnRe);
		panel.setComponentZOrder(btnRe, 0);

=======
		btnRe.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnRe);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnRe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaRe();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnSol = new JButton("G");
		btnSol.setBackground(new Color(255, 147, 74));
		btnSol.setForeground(new Color(255, 255, 255));
		btnSol.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnSol.setBounds(574, 141, 55, 45);
		setVisible(true);
		panel.add(btnSol);
		panel.setComponentZOrder(btnSol, 0);

=======
		btnSol.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnSol);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnSol.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaSol();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnSi = new JButton("B");
		btnSi.setBackground(new Color(255, 147, 74));
		btnSi.setForeground(new Color(255, 255, 255));
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnSi.setBounds(576, 233, 53, 45);
		setVisible(true);
		panel.add(btnSi);
		panel.setComponentZOrder(btnSi, 0);

=======
		btnSi.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnSi);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnSi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaSi();
			}
		});
<<<<<<< HEAD

=======
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		JButton btnMizinha = new JButton("E");
		btnMizinha.setBackground(new Color(255, 147, 74));
		btnMizinha.setForeground(new Color(255, 255, 255));
		btnMizinha.setFont(new Font("Tahoma", Font.PLAIN, 30));
<<<<<<< HEAD
		btnMizinha.setBounds(576, 324, 53, 45);
		setVisible(true);
		panel.add(btnMizinha);
		panel.setComponentZOrder(btnMizinha, 0);

=======
		btnMizinha.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnMizinha);
		
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
		btnMizinha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaMizinha();
			}
		});
<<<<<<< HEAD

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Afinador();
		});

	}
=======
		
	}
	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new Afinador();
	        });
	    }
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
}