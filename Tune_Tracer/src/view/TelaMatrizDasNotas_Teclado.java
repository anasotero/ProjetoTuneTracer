package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

import controller.Metodos;
import model.dao.ConexaoSQL;

public class TelaMatrizDasNotas_Teclado extends JFrame {

	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private JButton btnC, btnD;

	Color CorFundo = new Color(255, 245, 239);
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");

	public TelaMatrizDasNotas_Teclado() {
		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(CorFundo);
		getContentPane().setLayout(null);
		setIconImage(ocarina.getImage());
		Metodos.verificaTema((JComponent) getContentPane());

		// botões dos acordes
		btnC = new JButton("C");
		btnC.setForeground(new Color(255, 255, 255));
		btnC.setBackground(new Color(255, 145, 77));
		btnC.setBounds(71, 54, 94, 30);
		getContentPane().add(btnC);
		btnC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_C = new TelaNotaGenerica();
				dispose();
				ImageIcon CNR = new ImageIcon("imagens/Piano Notas/C.png");
				ImageIcon C = new ImageIcon(CNR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_C.nota_C.setText("C");
				TN_C.imagemC.setIcon(C);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_C.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_C.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("C", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("C", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_C.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.doPiano();
					}
				});

				TN_C.setVisible(true);
			}

		});

		btnD = new JButton("D");
		btnD.setForeground(Color.WHITE);
		btnD.setBackground(new Color(255, 145, 77));
		btnD.setBounds(71, 109, 94, 30);
		getContentPane().add(btnD);
		btnD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_D = new TelaNotaGenerica();
				dispose();
				ImageIcon DNR = new ImageIcon("imagens/Piano Notas/D.png");
				ImageIcon D = new ImageIcon(DNR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_D.nota_C.setText("D");
				TN_D.imagemC.setIcon(D);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_D.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_D.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("D", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("D", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_D.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.rePiano();
					}
				});

				TN_D.setVisible(true);
			}

		});

		JButton btnE = new JButton("E");
		btnE.setForeground(Color.WHITE);
		btnE.setBackground(new Color(255, 145, 77));
		btnE.setBounds(71, 164, 94, 30);
		getContentPane().add(btnE);
		btnE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_E = new TelaNotaGenerica();
				dispose();
				ImageIcon ENR = new ImageIcon("imagens/Piano Notas/E.png");
				ImageIcon E = new ImageIcon(ENR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_E.nota_C.setText("E");
				TN_E.imagemC.setIcon(E);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_E.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_E.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("E", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("E", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_E.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.miPiano();
					}
				});

				TN_E.setVisible(true);
			}

		});

		JButton btnF = new JButton("F");
		btnF.setForeground(Color.WHITE);
		btnF.setBackground(new Color(255, 145, 77));
		btnF.setBounds(71, 219, 94, 30);
		getContentPane().add(btnF);
		btnF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_F = new TelaNotaGenerica();
				dispose();
				ImageIcon FNR = new ImageIcon("imagens/Piano Notas/F.png");
				ImageIcon F = new ImageIcon(FNR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_F.nota_C.setText("F");
				TN_F.imagemC.setIcon(F);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_F.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_F.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("F", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("F", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_F.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.faPiano();
					}
				});

				TN_F.setVisible(true);
			}

		});
		

		JButton btnG = new JButton("G");
		btnG.setForeground(Color.WHITE);
		btnG.setBackground(new Color(255, 145, 77));
		btnG.setBounds(71, 272, 94, 30);
		getContentPane().add(btnG);
		btnG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_G = new TelaNotaGenerica();
				dispose();
				ImageIcon GNR = new ImageIcon("imagens/Piano Notas/G.png");
				ImageIcon G = new ImageIcon(GNR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_G.nota_C.setText("G");
				TN_G.imagemC.setIcon(G);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_G.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_G.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("G", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("G", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_G.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.solPiano();
					}
				});

				TN_G.setVisible(true);
			}

		});

		JButton btnA = new JButton("A");
		btnA.setForeground(Color.WHITE);
		btnA.setBackground(new Color(255, 145, 77));
		btnA.setBounds(71, 326, 94, 30);
		getContentPane().add(btnA);
		btnA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_A = new TelaNotaGenerica();
				dispose();
				ImageIcon ANR = new ImageIcon("imagens/Piano Notas/A.png");
				ImageIcon A = new ImageIcon(ANR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_A.nota_C.setText("A");
				TN_A.imagemC.setIcon(A);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_A.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_A.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("A", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("A", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_A.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.laPiano();
					}
				});

				TN_A.setVisible(true);
			}

		});

		JButton btnB = new JButton("B");
		btnB.setForeground(Color.WHITE);
		btnB.setBackground(new Color(255, 145, 77));
		btnB.setBounds(71, 384, 94, 30);
		getContentPane().add(btnB);
		btnB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Metodos.clickedSound();
				TelaNotaGenerica TN_B = new TelaNotaGenerica();
				dispose();
				ImageIcon BNR = new ImageIcon("imagens/Piano Notas/B.png");
				ImageIcon B = new ImageIcon(BNR.getImage().getScaledInstance(330, 180, Image.SCALE_DEFAULT));
				TN_B.nota_C.setText("B");
				TN_B.imagemC.setIcon(B);

				// estrelas para favoritar
				ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
				ImageIcon estrelaPretaRD = new ImageIcon(
						estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);

				ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
				ImageIcon estrelaAmarelaRD = new ImageIcon(
						estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
				JLabel estrelaAmarelaLabel = new JLabel(estrelaAmarelaRD);

				estrelaAmarelaLabel.setBounds(716, 391, 40, 40);
				estrelaAmarelaLabel.setLayout(null);
				estrelaAmarelaLabel.setVisible(false);
				TN_B.getContentPane().add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_B.getContentPane().add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("B", "Teclado");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("B", "Teclado");
						}
					}
				});

				ImageIcon som = new ImageIcon("imagens/som.png");
				ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));
				JLabel lblSom = new JLabel(som2);

				// configurações da foto do ícone do som
				lblSom.setLayout(null);
				lblSom.setVisible(true);
				lblSom.setBounds(660, 391, 40, 40);
				TN_B.getContentPane().add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.siPiano();
					}
				});

				TN_B.setVisible(true);
			}

		});

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
		setting.setFont(new Font("Arial", Font.BOLD, 14));
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
		retornar.setFont(new Font("Arial", Font.BOLD, 14));
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
	}

	public static void main(String[] args) {
		new TelaMatrizDasNotas_Teclado();
	}
}
