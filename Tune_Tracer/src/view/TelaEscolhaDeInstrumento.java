package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;

import controller.Metodos;
import model.dao.ConexaoSQL;
import view.MusicChooser;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class TelaEscolhaDeInstrumento extends JFrame {

	private JPanel contentpane;
	private JPanel panel_1, panel_2;
	private JLabel lblViolao, lblTeclado, lblFlauta;
	private JLabel Sair;
	
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect(); 

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon imagemGuitarNR = new ImageIcon("imagens/violão.png");
	ImageIcon imagemGuitar = new ImageIcon(imagemGuitarNR.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon imagemTecladoNR = new ImageIcon("imagens/teclado.png");
	ImageIcon imagemTeclado = new ImageIcon(imagemTecladoNR.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	ImageIcon imagemFlautaNR = new ImageIcon("imagens/flauta.png");
	ImageIcon imagemFlauta = new ImageIcon(imagemFlautaNR.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT));
	ImageIcon imagemSair = new ImageIcon("imagens/sair.png");
	ImageIcon sair = new ImageIcon(imagemSair.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
	
	public TelaEscolhaDeInstrumento() {
		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				setting.addActionListener(new ActionListener() {
	     		    @Override
	     		    public void actionPerformed(ActionEvent e) {
	     		        ConfigSis CO = new ConfigSis(conexao);
	     		        CO.setVisible(true);
	     		        dispose();
	     		    }
	     		});

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
				
				JMenuItem blog = new JMenuItem("Blogs de Música");
				blog.setForeground(new Color(255, 255, 255));
				blog.setBackground(new Color(255, 145, 77));
				btnMenu.add(blog);
				setVisible(true);
				
				blog.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TelaBlog TBL = new TelaBlog();
						TBL.setVisible(true);
						dispose();
					}
				});
				
				JMenuItem TV = new JMenuItem("Teclado Virtual");
				TV.setForeground(new Color(255, 255, 255));
				TV.setBackground(new Color(255, 145, 77));
				btnMenu.add(TV);
				setVisible(true);
				
				TV.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						TecladoVirtual tvc = new TecladoVirtual();
						tvc.setVisible(true);
						dispose();
					}
				});
				
				JMenuItem Musicas = new JMenuItem("Músicas de Exemplo");
				Musicas.setForeground(new Color(255, 255, 255));
				Musicas.setBackground(new Color(255, 145, 77));
				btnMenu.add(Musicas);
				setVisible(true);
				
				Musicas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MusicasDeExemplo ME = new MusicasDeExemplo();
						ME.setVisible(true);
						dispose();
					}
				});
<<<<<<< HEAD
				
				JMenuItem MusicaFundo = new JMenuItem("Música de fundo");
				MusicaFundo.setForeground(new Color(255, 255, 255));
				MusicaFundo.setBackground(new Color(255, 145, 77));
				btnMenu.add(MusicaFundo);
				setVisible(true);
				
				MusicaFundo.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						MusicChooser MC = new MusicChooser();
						MC.setVisible(true);
						dispose();
					}
				});
=======
>>>>>>> 56a682ac4de501ac07a836df713f630aae5741a2

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
		
		JLabel Sair = new JLabel(sair);
		

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
				TelaColunaDasNotas TCDN = new TelaColunaDasNotas();
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
				TelaMatrizDasNotas_Teclado TCDN = new TelaMatrizDasNotas_Teclado();
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
				TelaMatrizDasNotas_Flauta TCDN = new TelaMatrizDasNotas_Flauta();
				TCDN.setVisible(true);
				dispose();
				Metodos.fluteSound();
			}

		});
		
		contentpane.add(btnViolao);
		contentpane.add(btnTeclado);
		contentpane.add(btnFlauta);
		
		MusicPlayer musicPlayer = MusicPlayer.getInstance();
		String selectedMusicPath = loadSelectedMusicPath();
		
		if (selectedMusicPath != null) {
            musicPlayer.play(selectedMusicPath);
		}

		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	    public static void main(String[] args) {
	        MusicPlayer musicPlayer = MusicPlayer.getInstance();
	        new TelaEscolhaDeInstrumento();

	        // Tente recuperar o caminho do arquivo de música a partir do arquivo de configuração
	        String selectedMusicPath = loadSelectedMusicPath();

	        if (selectedMusicPath != null) {
	            musicPlayer.play(selectedMusicPath); // Reproduza a música de fundo automaticamente
	        }
	        
	    }

	    private static String loadSelectedMusicPath() {
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
	            String selectedMusicPath = reader.readLine();
	            reader.close();
	            return selectedMusicPath;
	        } catch (IOException e) {
	            return null; // Se ocorrer algum erro ou se o arquivo não existir, retorne null
	        }
	    }
	}




