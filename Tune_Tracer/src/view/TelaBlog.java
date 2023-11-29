package view;

import javax.swing.*;

import model.dao.ConexaoSQL;
import controller.Metodos;
import controller.OpenPDF;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class TelaBlog extends JFrame {

	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private ImageIcon ocarinaRE = new ImageIcon(ocarina.getImage().getScaledInstance(159, 159, Image.SCALE_DEFAULT));
	private ImageIcon instrumentoAntNR = new ImageIcon("imagens/instrumentoAntigo.png");
	private ImageIcon instrumentoAnt = new ImageIcon(
			instrumentoAntNR.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
	private ImageIcon partituraNR = new ImageIcon("imagens/partitura.png");
	private ImageIcon partitura = new ImageIcon(
			partituraNR.getImage().getScaledInstance(155, 130, Image.SCALE_DEFAULT));
	private ImageIcon notinhasNR = new ImageIcon("imagens/notinhas.png");
	private ImageIcon notinhas = new ImageIcon(notinhasNR.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon tamborNR = new ImageIcon("imagens/tambor.png");
	private ImageIcon tambor = new ImageIcon(tamborNR.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private Color CorFundo = new Color(255, 245, 239);
	private Color CorPanel = new Color(255, 145, 77);
	private Color CorLaranja = new Color(255, 192, 131);
	private Font fonte = new Font("Arial", Font.PLAIN, 16);

	public TelaBlog() {

		// Configurações da janela principal
		setTitle("Tune Tracer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(780, 500);
		setResizable(false);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(CorLaranja);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		Metodos.verificaTema((JComponent) getContentPane());

		JLabel imageCifra = new JLabel("Bb");
		imageCifra.setForeground(Color.BLACK);
		imageCifra.setFont(new Font("Times New Roman", Font.PLAIN, 100));
		imageCifra.setBounds(70, 15, 198, 196);
		getContentPane().add(imageCifra);
		
		JPanel panelCifra = new JPanel();
		panelCifra.setBackground(new Color(255, 255, 255));
		panelCifra.setBounds(49, 29, 160, 158);
		getContentPane().add(panelCifra);

		JLabel lblCifra = new JLabel("Cifra de Instrumentos");
		lblCifra.setForeground(new Color(255, 255, 255));
		lblCifra.setBounds(52, 193, 160, 22);
		lblCifra.setFont(fonte);
		getContentPane().add(lblCifra);
		lblCifra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCifra.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCifra.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblCifra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirBlogCifra();
			}
		});

		JLabel imageHistoria = new JLabel(instrumentoAnt);
		imageHistoria.setBounds(85, 215, 198, 196);
		getContentPane().add(imageHistoria);

		JPanel panelHistoria = new JPanel();
		panelHistoria.setBackground(Color.WHITE);
		panelHistoria.setBounds(49, 228, 160, 158);
		getContentPane().add(panelHistoria);

		JLabel lblHistoria = new JLabel("História da Música");
		lblHistoria.setForeground(new Color(255, 255, 255));
		lblHistoria.setBounds(63, 393, 160, 22);
		lblHistoria.setFont(fonte);
		getContentPane().add(lblHistoria);
		lblHistoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblHistoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblHistoria.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblHistoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirBlogHistoria();
			}
		});

		JLabel imageCampo = new JLabel(notinhas);
		imageCampo.setBounds(275, 10, 198, 196);
		getContentPane().add(imageCampo);

		JPanel panelCampo = new JPanel();
		panelCampo.setBackground(Color.WHITE);
		panelCampo.setBounds(294, 29, 160, 158);
		getContentPane().add(panelCampo);

		JLabel lblCampo = new JLabel("Campo Harmônico");
		lblCampo.setForeground(new Color(255, 255, 255));
		lblCampo.setBounds(310, 193, 160, 22);
		lblCampo.setFont(fonte);
		getContentPane().add(lblCampo);
		lblCampo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCampo.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCampo.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblCampo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirBlogCampo();
			}
		});

		JLabel imageTipos = new JLabel(tambor);
		imageTipos.setBounds(525, 10, 198, 196);
		getContentPane().add(imageTipos);
		
		JPanel panelTipos = new JPanel();
		panelTipos.setBackground(Color.WHITE);
		panelTipos.setBounds(545, 29, 160, 158);
		getContentPane().add(panelTipos);

		JLabel lblTipos = new JLabel("Tipos de Instrumentos");
		lblTipos.setForeground(new Color(255, 255, 255));
		lblTipos.setBounds(548, 193, 160, 22);
		lblTipos.setFont(fonte);
		getContentPane().add(lblTipos);
		lblTipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblTipos.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblTipos.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblTipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirBlogTipos();
			}
		});

		JLabel imagePartitura = new JLabel(partitura);
		imagePartitura.setBounds(274, 215, 198, 196);
		getContentPane().add(imagePartitura);

		JPanel panelPartitura = new JPanel();
		panelPartitura.setBackground(Color.WHITE);
		panelPartitura.setBounds(294, 228, 160, 158);
		getContentPane().add(panelPartitura);

		JLabel lblPartitura = new JLabel("Partituras");
		lblPartitura.setForeground(new Color(255, 255, 255));
		lblPartitura.setBounds(340, 393, 160, 22);
		lblPartitura.setFont(fonte);
		getContentPane().add(lblPartitura);
		lblPartitura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblPartitura.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblPartitura.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblPartitura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirBlogPartituras();
			}
		});

		JLabel imageManual = new JLabel(ocarinaRE);
		imageManual.setBounds(527, 212, 198, 196);
		getContentPane().add(imageManual);

		JPanel panelManual = new JPanel();
		panelManual.setBackground(Color.WHITE);
		panelManual.setBounds(545, 228, 160, 158);
		getContentPane().add(panelManual);

		JLabel lblManual = new JLabel("Manual do Usuário");
		lblManual.setForeground(new Color(255, 255, 255));
		lblManual.setBounds(560, 393, 160, 22);
		lblManual.setFont(fonte);
		getContentPane().add(lblManual);
		lblManual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblManual.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblManual.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
		lblManual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenPDF.abrirManual();
			}
		});

		// Exibe a janela
		setVisible(true);

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

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TelaBlog());
	}
}