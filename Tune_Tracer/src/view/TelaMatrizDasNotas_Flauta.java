package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.Metodos;

public class TelaMatrizDasNotas_Flauta extends JFrame{

	private JButton btnC, btnD;

	Color CorFundo = new Color(255, 245, 239);
	ImageIcon ocarina = new ImageIcon(getClass().getResource("ocarina.png"));
	ImageIcon voltar = new ImageIcon(getClass().getResource("botaoVoltar.png"));
	ImageIcon btnVoltar = new ImageIcon(voltar.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));


	public TelaMatrizDasNotas_Flauta() {
		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(CorFundo);
		getContentPane().setLayout(null);
		setIconImage(ocarina.getImage());

		// botões dos acordes
		btnC = new JButton("C");
		btnC.setForeground(new Color(255, 255, 255));
		btnC.setBackground(new Color(255, 145, 77));
		btnC.setBounds(71, 54, 94, 30);
		getContentPane().add(btnC);
		btnC.addActionListener(new ActionListener() {
			
	public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNota_C_Flauta TN_C = new TelaNota_C_Flauta();
				TN_C.setVisible(true);
				dispose();
			}
		});
		
		btnD = new JButton("D");
		btnD.setForeground(Color.WHITE);
		btnD.setBackground(new Color(255, 145, 77));
		btnD.setBounds(71, 109, 94, 30);
		getContentPane().add(btnD);
		
		JButton btnE = new JButton("E");
		btnE.setForeground(Color.WHITE);
		btnE.setBackground(new Color(255, 145, 77));
		btnE.setBounds(71, 164, 94, 30);
		getContentPane().add(btnE);
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JButton btnF = new JButton("F");
		btnF.setForeground(Color.WHITE);
		btnF.setBackground(new Color(255, 145, 77));
		btnF.setBounds(71, 219, 94, 30);
		getContentPane().add(btnF);
		
		JButton btnG = new JButton("G");
		btnG.setForeground(Color.WHITE);
		btnG.setBackground(new Color(255, 145, 77));
		btnG.setBounds(71, 272, 94, 30);
		getContentPane().add(btnG);
		
		JButton btnA = new JButton("A");
		btnA.setForeground(Color.WHITE);
		btnA.setBackground(new Color(255, 145, 77));
		btnA.setBounds(71, 326, 94, 30);
		getContentPane().add(btnA);
		
		JButton btnB = new JButton("B");
		btnB.setForeground(Color.WHITE);
		btnB.setBackground(new Color(255, 145, 77));
		btnB.setBounds(71, 384, 94, 30);
		getContentPane().add(btnB);
		
		JButton btnCm = new JButton("Cm");
		btnCm.setForeground(Color.WHITE);
		btnCm.setBackground(new Color(255, 145, 77));
		btnCm.setBounds(204, 54, 94, 30);
		getContentPane().add(btnCm);
		
		JButton btnDm = new JButton("Dm");
		btnDm.setForeground(Color.WHITE);
		btnDm.setBackground(new Color(255, 145, 77));
		btnDm.setBounds(204, 109, 94, 30);
		getContentPane().add(btnDm);
		
		JButton btnEm = new JButton("Em");
		btnEm.setForeground(Color.WHITE);
		btnEm.setBackground(new Color(255, 145, 77));
		btnEm.setBounds(204, 164, 94, 30);
		getContentPane().add(btnEm);
		
		JButton btnFm = new JButton("Fm");
		btnFm.setForeground(Color.WHITE);
		btnFm.setBackground(new Color(255, 145, 77));
		btnFm.setBounds(204, 219, 94, 30);
		getContentPane().add(btnFm);
		
		JButton btnGm = new JButton("Gm");
		btnGm.setForeground(Color.WHITE);
		btnGm.setBackground(new Color(255, 145, 77));
		btnGm.setBounds(204, 272, 94, 30);
		getContentPane().add(btnGm);
		
		JButton btnAm = new JButton("Am");
		btnAm.setForeground(Color.WHITE);
		btnAm.setBackground(new Color(255, 145, 77));
		btnAm.setBounds(204, 326, 94, 30);
		getContentPane().add(btnAm);
		
		JButton btnBm = new JButton("Bm");
		btnBm.setForeground(Color.WHITE);
		btnBm.setBackground(new Color(255, 145, 77));
		btnBm.setBounds(204, 384, 94, 30);
		getContentPane().add(btnBm);
		
		JButton btnC4 = new JButton("C4");
		btnC4.setForeground(Color.WHITE);
		btnC4.setBackground(new Color(255, 145, 77));
		btnC4.setBounds(335, 54, 94, 30);
		getContentPane().add(btnC4);
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnD4 = new JButton("D4");
		btnD4.setForeground(Color.WHITE);
		btnD4.setBackground(new Color(255, 145, 77));
		btnD4.setBounds(335, 109, 94, 30);
		getContentPane().add(btnD4);
		
		JButton btnE4 = new JButton("E4");
		btnE4.setForeground(Color.WHITE);
		btnE4.setBackground(new Color(255, 145, 77));
		btnE4.setBounds(335, 164, 94, 30);
		getContentPane().add(btnE4);
		btnE4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnF4 = new JButton("F4");
		btnF4.setForeground(Color.WHITE);
		btnF4.setBackground(new Color(255, 145, 77));
		btnF4.setBounds(335, 219, 94, 30);
		getContentPane().add(btnF4);
		
		JButton btnG4 = new JButton("G4");
		btnG4.setForeground(Color.WHITE);
		btnG4.setBackground(new Color(255, 145, 77));
		btnG4.setBounds(335, 272, 94, 30);
		getContentPane().add(btnG4);
		
		JButton btnA4 = new JButton("A4");
		btnA4.setForeground(Color.WHITE);
		btnA4.setBackground(new Color(255, 145, 77));
		btnA4.setBounds(335, 326, 94, 30);
		getContentPane().add(btnA4);
		
		JButton btnB4 = new JButton("B4");
		btnB4.setForeground(Color.WHITE);
		btnB4.setBackground(new Color(255, 145, 77));
		btnB4.setBounds(335, 384, 94, 30);
		getContentPane().add(btnB4);
		
		JButton btnC7 = new JButton("C7");
		btnC7.setForeground(Color.WHITE);
		btnC7.setBackground(new Color(255, 145, 77));
		btnC7.setBounds(465, 54, 94, 30);
		getContentPane().add(btnC7);
		
		JButton btnD7 = new JButton("D7");
		btnD7.setForeground(Color.WHITE);
		btnD7.setBackground(new Color(255, 145, 77));
		btnD7.setBounds(465, 109, 94, 30);
		getContentPane().add(btnD7);
		
		JButton btnE7 = new JButton("E7");
		btnE7.setForeground(Color.WHITE);
		btnE7.setBackground(new Color(255, 145, 77));
		btnE7.setBounds(465, 164, 94, 30);
		getContentPane().add(btnE7);
		
		JButton btnF7 = new JButton("F7");
		btnF7.setForeground(Color.WHITE);
		btnF7.setBackground(new Color(255, 145, 77));
		btnF7.setBounds(465, 219, 94, 30);
		getContentPane().add(btnF7);
		btnF7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnG7 = new JButton("G7");
		btnG7.setForeground(Color.WHITE);
		btnG7.setBackground(new Color(255, 145, 77));
		btnG7.setBounds(465, 272, 94, 30);
		getContentPane().add(btnG7);
		
		JButton btnA7 = new JButton("A7");
		btnA7.setForeground(Color.WHITE);
		btnA7.setBackground(new Color(255, 145, 77));
		btnA7.setBounds(465, 326, 94, 30);
		getContentPane().add(btnA7);
		
		JButton btnB7 = new JButton("B7");
		btnB7.setForeground(Color.WHITE);
		btnB7.setBackground(new Color(255, 145, 77));
		btnB7.setBounds(465, 384, 94, 30);
		getContentPane().add(btnB7);
		
		JButton btnC9 = new JButton("C9");
		btnC9.setForeground(Color.WHITE);
		btnC9.setBackground(new Color(255, 145, 77));
		btnC9.setBounds(590, 54, 94, 30);
		getContentPane().add(btnC9);
		
		JButton btnD9 = new JButton("D9");
		btnD9.setForeground(Color.WHITE);
		btnD9.setBackground(new Color(255, 145, 77));
		btnD9.setBounds(590, 109, 94, 30);
		getContentPane().add(btnD9);
		
		JButton btnE9 = new JButton("E9");
		btnE9.setForeground(Color.WHITE);
		btnE9.setBackground(new Color(255, 145, 77));
		btnE9.setBounds(590, 164, 94, 30);
		getContentPane().add(btnE9);
		
		JButton btnF9 = new JButton("F9");
		btnF9.setForeground(Color.WHITE);
		btnF9.setBackground(new Color(255, 145, 77));
		btnF9.setBounds(590, 219, 94, 30);
		getContentPane().add(btnF9);
		
		JButton btnG9 = new JButton("G9");
		btnG9.setForeground(Color.WHITE);
		btnG9.setBackground(new Color(255, 145, 77));
		btnG9.setBounds(590, 272, 94, 30);
		getContentPane().add(btnG9);
		
		JButton btnA9 = new JButton("A9");
		btnA9.setForeground(Color.WHITE);
		btnA9.setBackground(new Color(255, 145, 77));
		btnA9.setBounds(590, 326, 94, 30);
		getContentPane().add(btnA9);
		
		JButton btnB9 = new JButton("B9");
		btnB9.setForeground(Color.WHITE);
		btnB9.setBackground(new Color(255, 145, 77));
		btnB9.setBounds(590, 384, 94, 30);
		getContentPane().add(btnB9);
		btnB9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

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
		        Favoritadas TFA = new Favoritadas();
		        TFA.setVisible(true);
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
		    	TelaEscolhaDeInstrumento TDI2 = new TelaEscolhaDeInstrumento();
		        TDI2.setVisible(true);
		        dispose();
		    }
		});
	}
	        

	public static void main(String[] args) {
		new TelaMatrizDasNotas_Flauta();
	}
}
