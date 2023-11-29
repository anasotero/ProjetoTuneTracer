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
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controller.Metodos;
import model.dao.ConexaoSQL;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public class TecladoVirtual extends JFrame {
	
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect(); 

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private ImageIcon tecladoNR = new ImageIcon("imagens/teclado padrão.png");
	private ImageIcon tecladoC_NR = new ImageIcon("imagens/teclado C.png");
	
	private ImageIcon teclado = new ImageIcon(tecladoNR.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
	private ImageIcon tecladoC = new ImageIcon(tecladoC_NR.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
	
	private JLabel lblTeclado = new JLabel(teclado);
	private JLabel lblTecladoC = new JLabel(tecladoC);
	private Color fundo = new Color(255, 192, 131);

	public TecladoVirtual() {

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(fundo);
		getContentPane().setLayout(null);
		Metodos.verificaTema((JComponent) getContentPane());

		JPanel teclaC = new JPanel();
		teclaC.setBackground(new Color(255, 255, 255));
		teclaC.setVisible(true);
		teclaC.setBounds(74, 285, 70, 109);
		getContentPane().add(teclaC);
		teclaC.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.C();
		    }
		});
		
		JPanel teclaCS = new JPanel();
		teclaCS.setBackground(new Color(0, 0, 0));
		teclaCS.setVisible(true);
		teclaCS.setBounds(136, 118, 59, 150);
		getContentPane().add(teclaCS);
		teclaCS.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.CS();
		    }
		});
		
		JPanel teclaD = new JPanel();
		teclaD.setBackground(new Color(255, 255, 255));
		teclaD.setVisible(true);
		teclaD.setBounds(175, 285, 70, 109);
		getContentPane().add(teclaD);
		teclaD.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.D();
		    }
		});
		
		JPanel teclaDS = new JPanel();
		teclaDS.setBackground(new Color(0, 0, 0));
		teclaDS.setVisible(true);
		teclaDS.setBounds(226, 118, 59, 150);
		getContentPane().add(teclaDS);
		teclaDS.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.DS();
		    }
		});
		
		JPanel teclaE = new JPanel();
		teclaE.setBackground(new Color(255, 255, 255));
		teclaE.setVisible(true);
		teclaE.setBounds(267, 285, 70, 109);
		getContentPane().add(teclaE);
		teclaE.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.E();
		    }
		});
		
		JPanel teclaF = new JPanel();
		teclaF.setBackground(new Color(255, 255, 255));
		teclaF.setVisible(true);
		teclaF.setBounds(355, 285, 70, 109);
		getContentPane().add(teclaF);
		teclaF.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.F();
		    }
		});
		
		JPanel teclaFS = new JPanel();
		teclaFS.setBackground(new Color(0, 0, 0));
		teclaFS.setVisible(true);
		teclaFS.setBounds(398, 118, 59, 150);
		getContentPane().add(teclaFS);
		teclaFS.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.FS();
		    }
		});
		
		JPanel teclaG = new JPanel();
		teclaG.setBackground(new Color(255, 255, 255));
		teclaG.setVisible(true);
		teclaG.setBounds(438, 285, 70, 109);
		getContentPane().add(teclaG);
		teclaG.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.G();
		    }
		});
		
		JPanel teclaGS = new JPanel();
		teclaGS.setBackground(new Color(0, 0, 0));
		teclaGS.setVisible(true);
		teclaGS.setBounds(486, 118, 59, 150);
		getContentPane().add(teclaGS);
		teclaGS.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.GS();
		    }
		});
		
		JPanel teclaA = new JPanel();
		teclaA.setBackground(new Color(255, 255, 255));
		teclaA.setVisible(true);
		teclaA.setBounds(525, 285, 70, 109);
		getContentPane().add(teclaA);
		teclaA.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.A();
		    }
		});
		
		JPanel teclaAS = new JPanel();
		teclaAS.setBackground(new Color(0, 0, 0));
		teclaAS.setVisible(true);
		teclaAS.setBounds(570, 118, 59, 150);
		getContentPane().add(teclaAS);
		teclaAS.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.AS();
		    }
		});
		
		JPanel teclaB = new JPanel();
		teclaB.setBackground(new Color(255, 255, 255
				));
		teclaB.setVisible(true);
		teclaB.setBounds(615, 285, 70, 109);
		getContentPane().add(teclaB);
		teclaB.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        Metodos.B();
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

		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TecladoVirtual();
	}
}