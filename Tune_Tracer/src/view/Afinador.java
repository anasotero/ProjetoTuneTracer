package view;

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
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon afina  = new ImageIcon("imagens/Afinador.png");
	ImageIcon afinaa = new ImageIcon(afina.getImage().getScaledInstance(780, 500, Image.SCALE_DEFAULT));
	private JLabel afinaaa = new JLabel(afinaa);
	
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // ObtnMizonaenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect(); 
	static ConexaoSQL sq = new ConexaoSQL();
	static LoginController logcon = new LoginController(sq);
	
	public Afinador() {
		setTitle("Afinador");
		setResizable(false);
		getContentPane().setLayout(null);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		setBackground(new Color(255, 204, 153));
		setVisible(true);
		setLocationRelativeTo(null);
		
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
		btnMizona.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnMizona);
		
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
		btnLa.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnLa);
		
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
		btnRe.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnRe);
		
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
		btnSol.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnSol);
		
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
		btnSi.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnSi);
		
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
		btnMizinha.setBounds(536, 328, 198, 40);
		setVisible(true);
		panel.add(btnMizinha);
		
		btnMizinha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.som_CordaMizinha();
			}
		});
		
	}
	
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new Afinador();
	        });
	    }
}