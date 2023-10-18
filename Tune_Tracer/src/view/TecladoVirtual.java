package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Metodos;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TecladoVirtual extends JFrame {

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private ImageIcon tecladoNR = new ImageIcon("imagens/teclado padrão.png");
	private ImageIcon tecladoC_NR = new ImageIcon("imagens/teclado C.png");
	
	private ImageIcon teclado = new ImageIcon(tecladoNR.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
	private ImageIcon tecladoC = new ImageIcon(tecladoC_NR.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
	
	private JLabel lblTeclado = new JLabel(teclado);
	private JLabel lblTecladoC = new JLabel(tecladoC);
	private Color fundo = new Color(255, 192, 131);
	private static Connection connect;

	public TecladoVirtual(Connection connect) {
		
		this.connect = connect;

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(fundo);
		getContentPane().setLayout(null);

		JPanel teclaC = new JPanel();
		teclaC.setBackground(new Color(0, 128, 0));
		teclaC.setVisible(true);
		teclaC.setBounds(74, 285, 70, 109);
		getContentPane().add(teclaC);
		teclaC.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	
		        lblTeclado.setVisible(false);
		        lblTecladoC.setVisible(true);
		        
		    }
		});
		
		// configurações do teclado virtual
		lblTeclado.setLayout(null);
		lblTeclado.setVisible(true);
		lblTeclado.setBounds(0, 0, 766, 441);
		getContentPane().add(lblTeclado);
		
		lblTecladoC.setLayout(null);
		lblTecladoC.setBounds(0, 0, 766, 441);
		getContentPane().add(lblTecladoC);

		// configurações do JMenu
		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);

		JMenu btnMenu = new JMenu("Menu");
		btnMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMenu);

		JMenuItem setting = new JMenuItem("Configurações");
		setting.setBackground(new Color(255, 145, 77));
		setting.setForeground(new Color(255, 255, 255));
		btnMenu.add(setting);
		setVisible(true);

		JMenuItem notasFavoritas = new JMenuItem("Favoritadas");
		notasFavoritas.setForeground(new Color(255, 255, 255));
		notasFavoritas.setBackground(new Color(255, 145, 77));
		btnMenu.add(notasFavoritas);
		setVisible(true);

		notasFavoritas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Favoritadas TFA = new Favoritadas(connect);
				TFA.setVisible(true);
				dispose();
			}
		});

		JMenuItem blog = new JMenuItem("Blogs de Música");
		blog.setForeground(new Color(255, 255, 255));
		blog.setBackground(new Color(255, 145, 77));
		btnMenu.add(blog);
		setVisible(true);
		
		blog.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaBlog TBL = new TelaBlog(connect);
				TBL.setVisible(true);
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
				TelaEscolhaDeInstrumento TDI2 = new TelaEscolhaDeInstrumento(connect);
				TDI2.setVisible(true);
				dispose();
			}
		});

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TecladoVirtual(connect);
	}
}