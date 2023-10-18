package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import controller.Metodos;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaEscolhaDeInstrumento extends JFrame {

	private JPanel contentpane;
	private JPanel panel_1, panel_2;
	private JLabel lblViolao, lblTeclado, lblFlauta;
	private static Connection connect;

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	
	ImageIcon imagemGuitarNR = new ImageIcon("imagens/violão.png");
	ImageIcon imagemGuitar = new ImageIcon(imagemGuitarNR.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon imagemTecladoNR = new ImageIcon("imagens/teclado.png");
	ImageIcon imagemTeclado = new ImageIcon(imagemTecladoNR.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon imagemFlautaNR = new ImageIcon("imagens/flauta.png");
	ImageIcon imagemFlauta = new ImageIcon(imagemFlautaNR.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT));

	
	public TelaEscolhaDeInstrumento(Connection connect) {
		
		this.connect = connect;
		
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

		JPanel panel = new JPanel();
		panel.setBounds(10, 125, 230, 193);
		contentpane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(266, 125, 230, 193);
		contentpane.add(panel_1);
		
		// adicionando as ilustrações dos instrumentos
		JLabel guitar = new JLabel(imagemGuitar);
		guitar.setBounds(30, 125, 166, 193);
		panel.add(guitar);
		guitar.setLabelFor(contentpane);
		contentpane.setComponentZOrder(guitar, 0);
		
		JLabel teclado = new JLabel(imagemTeclado);
		teclado.setBounds(266, 125, 230, 193);
		panel_1.add(teclado);
		teclado.setLabelFor(contentpane);
		contentpane.setComponentZOrder(teclado, 0);
		
		JLabel flauta = new JLabel(imagemFlauta);
		flauta.setVerticalAlignment(SwingConstants.TOP);
		flauta.setBounds(525, 100, 232, 193);
		panel.add(flauta);
		flauta.setLabelFor(contentpane);
		contentpane.setComponentZOrder(flauta, 0);

		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(526, 125, 230, 193);
		contentpane.add(panel_2);

		// adicionando os botões 
		JButton btnViolao = new JButton("Violão");
		btnViolao.setBackground(new Color(255, 147, 74));
		btnViolao.setForeground(new Color(255, 255, 255));
		btnViolao.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnViolao.setBounds(58, 330, 132, 40);
		btnViolao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaColunaDasNotas TCDN = new TelaColunaDasNotas(connect);
				TCDN.setVisible(true);
				dispose();
				Metodos.guitarSound();
			}

		});
		
		JButton btnTeclado = new JButton("Teclado");
		btnTeclado.setBackground(new Color(255, 147, 74));
		btnTeclado.setForeground(new Color(255, 255, 255));
		btnTeclado.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnTeclado.setBounds(286, 330, 198, 40);
		btnTeclado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMatrizDasNotas_Teclado TCDN = new TelaMatrizDasNotas_Teclado(connect);
				TCDN.setVisible(true);
				dispose();
				Metodos.keyboardSound();
			}

		});
		
		JButton btnFlauta = new JButton("Flauta");
		btnFlauta.setBackground(new Color(255, 147, 74));
		btnFlauta.setForeground(new Color(255, 255, 255));
		btnFlauta.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnFlauta.setBounds(536, 328, 198, 40);
		btnFlauta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TelaMatrizDasNotas_Flauta TCDN = new TelaMatrizDasNotas_Flauta(connect);
				TCDN.setVisible(true);
				dispose();
				Metodos.fluteSound();
			}

		});
		
		contentpane.add(btnViolao);
		contentpane.add(btnTeclado);
		contentpane.add(btnFlauta);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaEscolhaDeInstrumento(connect);
	}
}
