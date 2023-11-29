package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import javax.swing.*;

import controller.Metodos;
import model.dao.ConexaoSQL;

public class TelaMatrizDasNotas_Flauta extends JFrame {

	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private JButton btnC, btnD;

	Color CorFundo = new Color(255, 245, 239);
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");

	public TelaMatrizDasNotas_Flauta() {
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
				ImageIcon CNR = new ImageIcon("imagens/representacao.jpg");
				ImageIcon C = new ImageIcon(CNR.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("C", "Flauta");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("C", "Flauta");
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
						Metodos.doFlauta();
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
				ImageIcon DNR = new ImageIcon("imagens/representacao D.jpg");
				ImageIcon D = new ImageIcon(DNR.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
				TN_D.nota_C.setText("D");
				TN_D.imagemC.setIcon(D);

				// configurações dos botões

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
				TN_D.add(estrelaAmarelaLabel);

				estrelaPretaLabel.setBounds(716, 391, 40, 40);
				estrelaPretaLabel.setLayout(null);
				estrelaPretaLabel.setVisible(true);
				TN_D.add(estrelaPretaLabel);
				estrelaPretaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaPretaLabel.isVisible()) {
							estrelaPretaLabel.setVisible(false);
							estrelaAmarelaLabel.setVisible(true);
							Metodos.favoritadoSound();
							Metodos.FavoritarNota("D", "Flauta");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("D", "Flauta");
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
				TN_D.add(lblSom);
				lblSom.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						Metodos.reFlauta();
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
				ImageIcon ENR = new ImageIcon("imagens/representacao E.jpg");
				ImageIcon E = new ImageIcon(ENR.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("E", "Flauta");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("E", "Flauta");
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
						Metodos.miFlauta();
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
				ImageIcon FNR = new ImageIcon("imagens/representacao F.jpg");
				ImageIcon F = new ImageIcon(FNR.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("F", "Flauta");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("F", "Flauta");
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
						Metodos.faFlauta();
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
				ImageIcon GNR = new ImageIcon("imagens/representacao G.jpg");
				ImageIcon G = new ImageIcon(GNR.getImage().getScaledInstance(350, 200, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("G", "Flauta");
						}
					}
				});
				estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("G", "Flauta");
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
						Metodos.solFlauta();
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
				ImageIcon ANR = new ImageIcon("imagens/representacao A.jpg");
				ImageIcon A = new ImageIcon(ANR.getImage().getScaledInstance(350,200, Image.SCALE_DEFAULT));
				TN_A.nota_C.setText("A");
				TN_A.imagemC.setIcon(A);
				
				// estrelas para favoritar
		        ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
		        ImageIcon estrelaPretaRD = new ImageIcon(estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		        JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);
		        
		        ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
		        ImageIcon estrelaAmarelaRD = new ImageIcon(estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("A","Flauta");
						}
				}});
		        estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("A", "Flauta");
						}
				}});
		        
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
						Metodos.laFlauta();
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
				ImageIcon BNR = new ImageIcon("imagens/representacao B.jpg");
				ImageIcon B = new ImageIcon(BNR.getImage().getScaledInstance(350,200, Image.SCALE_DEFAULT));
				TN_B.nota_C.setText("B");
				TN_B.imagemC.setIcon(B);
				
				// estrelas para favoritar
		        ImageIcon estrelaPreta = new ImageIcon("imagens/estrelaPreta.png");
		        ImageIcon estrelaPretaRD = new ImageIcon(estrelaPreta.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
		        JLabel estrelaPretaLabel = new JLabel(estrelaPretaRD);
		        
		        ImageIcon estrelaAmarela = new ImageIcon("imagens/estrelaAmarela.png");
		        ImageIcon estrelaAmarelaRD = new ImageIcon(estrelaAmarela.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
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
							Metodos.FavoritarNota("B","Flauta");
						}
				}});
		        estrelaAmarelaLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (estrelaAmarelaLabel.isVisible()) {
							estrelaAmarelaLabel.setVisible(false);
							estrelaPretaLabel.setVisible(true);
							Metodos.Desfavoritar("B", "Flauta");
						}
				}});
		        
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
						Metodos.siFlauta();
					}
				});
						
				TN_B.setVisible(true);
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
<<<<<<< HEAD
		setting.setForeground(new Color(128, 128, 128));
=======
<<<<<<< HEAD
		setting.setForeground(new Color(128, 128, 128));
=======
		setting.setForeground(new Color(255, 255, 255));
>>>>>>> bcdb8ce7d72a759f8473f6d93e0ecaceb505ad1b
>>>>>>> f158ddb8afa2599468f0bc42d92f482451467e7a
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
		new TelaMatrizDasNotas_Flauta();
	}
}
