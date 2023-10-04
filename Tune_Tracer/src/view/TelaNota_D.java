package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import controller.Metodos;
import model.dao.ConexaoSQL;
import model.dao.FavoritosInsertDAO;
import model.vo.FavoritosVO;

@SuppressWarnings("serial")
public class TelaNota_D extends JFrame {

	private ConexaoSQL sq;
	Color CorFundo = new Color(255, 245, 239);
	Color CorPanel = new Color(255, 145, 77);

	Font fonte = new Font("Arial", Font.PLAIN, 26);

	ImageIcon D = new ImageIcon("imagens/D.jpeg");
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon favoritado = new ImageIcon("imagens/estrelaPreta.png");
	ImageIcon favoritadoRE = new ImageIcon(favoritado.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	ImageIcon favoritado2 = new ImageIcon("imagens/estrelaAmarela.png");
	ImageIcon favoritadoRE2 = new ImageIcon(favoritado2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));

	JLabel estrelaDesativada = new JLabel(favoritadoRE);
	JLabel estrelaAtivada = new JLabel(favoritadoRE2);
	JLabel imagemD = new JLabel(D);
	JLabel nota_D = new JLabel("D");

	JPanel panel = new JPanel();

	public TelaNota_D() {
		// configurações da janela
		setTitle("Tune Tracer");
		setBounds(1080, 720, 780, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setBackground(CorFundo);
		getContentPane().setLayout(null);
		setIconImage(ocarina.getImage());

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

		notasFavoritas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Favoritadas TFA = new Favoritadas();
				TFA.setVisible(true);
				dispose();
			}
		});
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
				TelaColunaDasNotas TCDN = new TelaColunaDasNotas();
				TCDN.setVisible(true);
				dispose();
			}
		});

		retornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaColunaDasNotas TCDN = new TelaColunaDasNotas();
				TCDN.setVisible(true);
				dispose();
			}
		});
		// configurações do panel
		panel.setBounds(298, 35, 177, 56);
		getContentPane().add(panel);
		panel.setBackground(CorPanel);
		panel.setLayout(null);
		nota_D.setBounds(77, 14, 22, 24);
		panel.add(nota_D);

		// configurações do JLabel (nota C)
		nota_D.setFont(fonte);
		nota_D.setForeground(Color.white);

		// configurações da foto da nota
		imagemD.setLayout(null);
		imagemD.setBounds(219, 101, 330, 338);
		getContentPane().add(imagemD);

		// configurações da estrela amarela (não habilitada ainda)
		estrelaAtivada.setLayout(null);
		estrelaAtivada.setVisible(false);
		estrelaAtivada.setBounds(716, 391, 40, 40);
		getContentPane().add(estrelaAtivada);
		estrelaAtivada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (estrelaAtivada.isVisible()) {
					estrelaAtivada.setVisible(false);
					estrelaDesativada.setVisible(true);
					DesfavoritarNOTA();
				}
			}
		});

		// configurações da estrela preta
		estrelaDesativada.setLayout(null);
		estrelaDesativada.setBounds(716, 391, 40, 40);
		estrelaDesativada.setVisible(true);
		getContentPane().add(estrelaDesativada);
		estrelaDesativada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (estrelaDesativada.isVisible()) {
					estrelaDesativada.setVisible(false);
					estrelaAtivada.setVisible(true);
					Metodos.favoritadoSound();
				}
				favoritarNOTA();
			}
		});

	}

	private void favoritarNOTA() {

		try (Connection conected = sq.getConect()) {
			FavoritosVO FV = new FavoritosVO("D", "Violão");
			FavoritosInsertDAO FID = new FavoritosInsertDAO(conected);
			FID.favoritar(FV);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erro em favoritar nota " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void DesfavoritarNOTA() {

		try (Connection conected = sq.getConect()) {
			FavoritosVO si = new FavoritosVO("C", "Violão");
			FavoritosInsertDAO FID = new FavoritosInsertDAO(conected);
			FID.desfavoritar(si);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, "Erro em Desfavoritar nota " + e.getMessage(), "Erro",
					JOptionPane.ERROR_MESSAGE);
		}
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaNota_D();
	}

}
