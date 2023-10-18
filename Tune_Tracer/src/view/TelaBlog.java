package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class TelaBlog extends JFrame {

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private JTabbedPane tabbedPane;
	private Color CorFundo = new Color(255, 245, 239);
	private Color CorPanel = new Color(255, 145, 77);
	private Color CorLaranja = new Color(255,192,131);
	private static Connection connect;

	public TelaBlog(Connection connect) {
		
		this.connect = connect;

		// Configurações da janela principal
		setTitle("Tune Tracer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(780, 500);
		setResizable(false);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(CorLaranja);

		// Criação do JTabbedPane
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 766, 441);
		tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
		tabbedPane.setBackground(Color.WHITE);

		// configurações do painel 1
		JPanel CifraIns = new JPanel();
		CifraIns.setBackground(CorFundo);
		
		// Crie um JTextArea (ou qualquer outro componente que você queira)
		JTextArea textArea = new JTextArea(25,53);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea.append("\t              CIFRAS DOS INSTRUMENTOS "
				+ "\n\n são uma notação simplificada usada por músicos,"
				+ " \n especialmente amadores, para representar acordes de maneira compreensível."
				+ " \n Elas consistem em letras e números que indicam qual acorde deve ser tocado em um"
				+ " \n determinado momento em uma música. Essa notação é muito utilizada em músicas"
				+ "\n populares e rock, sendo uma forma acessível para músicos iniciantes ou amadores"
				+ "\n tocarem suas músicas favoritas.\r\n"
				+ "\r\n"
				+ "\n\t\tCOMO FUNCIONAM:\r\n"
				+ "\r\n"
				+ " Letras: Representam os acordes principais, como C (Dó), G (Sol), Am (Lá menor), etc.\r\n"
				+ " Números: Indicam a posição do acorde na escala, muitas vezes relacionados aos"
				+ " \n trastes de um violão ou às teclas de um teclado.\r\n"
				);
		
		textArea.append("\n\n\t\t    C --> Dó"
				       +"\n\n\t\t    D --> Ré"
		               +"\n\n\t\t    E --> Mi"
		               +"\n\n\t\t    F --> Fá"
		               +"\n\n\t\t    G --> Sol"
		               +"\n\n\t\t    A --> Lá"
		               +"\n\n\t\t    B --> Si\n\n");
		
		CifraIns.setLayout(null);
		textArea.setEditable(false); // para tornar o JTextArea somente leitura
		
		// Adiciona o JTextArea a um JScrollPane
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(31, 5, 573, 406);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// Adiciona o JScrollPane ao JPanel
		CifraIns.add(scrollPane);

		
		// configurações do painel 2
		JPanel TiposIns = new JPanel();
		TiposIns.setBackground(CorFundo);
		
		// Crie um JTextArea (ou qualquer outro componente que você queira)
		JTextArea textArea2 = new JTextArea(25,53);
		textArea2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea2.append("\t\tTIPOS DE INSTRUMENTOS");
		textArea2.append(" \n\n Vamos explorar alguns dos principais tipos de instrumentos, destacando três"
				+ "\n exemplos de cada categoria.");	
		textArea2.append("\n\n\t                   INSTRUMENTOS DE CORDA\n\n");
				textArea2.append("\t1.Violão:\n"
				+ "\r\n"
				+ " Um dos instrumentos mais populares, o violão é versátil e adequado para"
				+ "\n uma variedade de estilos musicais. Suas cordas de aço ou nylon produzem uma"
				+ "\n ampla gama de sons, desde suaves acordes até notas vibrantes de solos.\r\n"
				+ "\n\t2. Violino:\r\n"
				+ "\r\n"
				+ " Pertencente à família das cordas, o violino é conhecido por sua expressividade"
				+ "\n e agudos límpidos. Usado em orquestras clássicas, música folclórica e até mesmo"
				+ "\n em gêneros modernos, o violino oferece uma ampla gama de possibilidades sonoras.\r\n"
				+ "\n\t3. Baixo Elétrico:\r\n"
				+ "\r\n"
				+ " Fundamentando a seção rítmica, o baixo elétrico é crucial para muitos"
				+ "\n estilos musicais, como o jazz, o rock e o funk. Suas notas graves adicionam"
				+ "\n profundidade e groove à música.\r\n"
				+ " \n\n\t\tINSTRUMENTOS DE SOPRO:\r\n"
				+ "\n\t1. Saxofone:\r\n"
				+ "\r\n"
				+ " Um ícone do jazz, o saxofone é um instrumento de sopro poderoso e expressivo."
				+ "\n Disponível em vários tamanhos, desde sopranino até o poderoso barítono, o saxofone"
				+ "\n é conhecido por sua versatilidade.\r\n"
				+ "\n\t2. Trompete:\r\n"
				+ "\r\n"
				+ " O trompete, com seu timbre brilhante e características marcantes, é frequentemente"
				+ "\n encontrado em bandas de metais, orquestras e gêneros como o jazz. É capaz de"
				+ "\n tocar melodias vibrantes e fanfarras emocionantes.\r\n"
				+ "\n\t3. Flauta Transversal:\r\n"
				+ "\r\n"
				+ " A flauta transversal emite um som doce e lírico. É um dos instrumentos mais"
				+ "\n antigos e é utilizado em uma variedade de gêneros, desde música clássica até"
				+ "\n trilhas sonoras de filmes.\r\n"
				+ "\n\t                INSTRUMENTOS DE PERCUSSÃO:\r\n"
				+ "\n\t1. Bateria:\r\n"
				+ "\r\n"
				+ " O coração da seção rítmica, a bateria é composta por tambores, pratos"
				+ "\n e outros elementos. É essencial em estilos como rock, pop e jazz, proporcionando"
				+ "\n ritmo e energia.\r\n"
				+ "\n\t2. Djembe:\r\n"
				+ "\r\n"
				+ " Originário da África Ocidental, o djembe é um tambor de mão esculpido em um"
				+ "\n único bloco de madeira. Suas batidas podem variar de suaves e melódicas a ritmos"
				+ "\n pulsantes e energéticos.\r\n"
				+ "\n\t3. Xilofone:\r\n"
				+ "\r\n"
				+ " Um instrumento de percussão melódica, o xilofone é formado por barras de madeira"
				+ "\n dispostas em ordem crescente de tamanho. Produz notas claras e é frequentemente"
				+ "\n usado em conjuntos de música clássica.\r\n"
				+"\n--------------------------------------------------------------------------------------"
				+ "-------------------------------------------------------------"
				+ "\n\n Cada tipo de instrumento contribui de maneira única"
				+ "\n para a riqueza e diversidade do mundo da música. Ao explorar"
				+ "\n essas diferentes categorias, os músicos têm a oportunidade de"
				+ "\n descobrir novos sons, técnicas e estilos, contribuindo para a tapeçaria"
				+ "\n musical global. "
				+ "\n\n\nEntão, qual instrumento você escolheria para começar sua jornada musical?\n\n");
		
		TiposIns.setLayout(null);
		textArea2.setEditable(false); // para tornar o JTextArea somente leitura
		
		// Adiciona o JTextArea a um JScrollPane
		JScrollPane scrollPane2 = new JScrollPane(textArea2);
		scrollPane2.setBounds(31, 5, 573, 406);
		scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// Adiciona o JScrollPane ao JPanel
		TiposIns.add(scrollPane2);
				
		
		// configurações do painel 3
		JPanel CampoHarm = new JPanel();
		CampoHarm.setBackground(CorFundo);
		
		// Crie um JTextArea (ou qualquer outro componente que você queira)
		JTextArea textArea3 = new JTextArea(25,53);
		textArea3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textArea3.append("\t\tCAMPO HARMÔNICO");
		textArea3.append("\n\n Um campo harmônico é um conjunto de acordes que são derivados das notas"
				+ "\n de uma escala. Para entender melhor, podemos imaginar a escala como uma sequência"
				+ "\n ordenada de notas que formam a base musical de uma composição. "
				+ "\n\n A partir dessas notas, podemos construir acordes que, quando tocados"
				+ "\n em conjunto, criam harmonia.");
		textArea3.append("\n\n\tEXEMPLO PRÁTICO: CAMPO HARMÔNICO MAIOR");
		textArea3.append("\n\n\tC Maior (I grau): C - E - G\r\n"
				+ "\tD Menor (II grau): D - F - A\r\n"
				+ "\tE Menor (III grau): E - G - B\r\n"
				+ "\tF Maior (IV grau): F - A - C\r\n"
				+ "\tG Maior (V grau): G - B - D\r\n"
				+ "\tA Menor (VI grau): A - C - E\r\n"
				+ "\tB Diminuto (VII grau): B - D - F");
		textArea3.append("\n\n              CAMPO HARMÔNICO MENOR: UMA VARIAÇÃO EMOTIVA\n");
		textArea3.append("\n\tA Menor (I grau): A - C - E\r\n"
				+ " \tB Diminuto (II grau): B - D - F\r\n"
				+ " \tC Maior (III grau): C - E - G\r\n"
				+ " \tD Menor (IV grau): D - F - A\r\n"
				+ " \tE Menor (V grau): E - G - B\r\n"
				+ " \tF Maior (VI grau): F - A - C\r\n"
				+ " \tG Maior (VII grau): G - B - D\n\n");
		textArea3.append("\n\t\tQUAL A UTILIDADE?\n\n");
		textArea3.append(" Compreender como os acordes se relacionam entre si oferece aos músicos uma"
				+ "\n base sólida para improvisação, composição e compreensão mais profunda da"
				+ "\n música que ouvimos.\n\n");
				
		CampoHarm.setLayout(null);
		textArea3.setEditable(false); // para tornar o JTextArea somente leitura
		
		// Adiciona o JTextArea a um JScrollPane
		JScrollPane scrollPane3 = new JScrollPane(textArea3);
		scrollPane3.setBounds(31, 5, 573, 406);
		scrollPane3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// Adiciona o JScrollPane ao JPanel
		CampoHarm.add(scrollPane3);
				
				
		adicionarAba("Cifras dos Instrumentos", CifraIns);
		adicionarAba("Tipos de Instrumentos", TiposIns);
		adicionarAba("Campo Harmônico", CampoHarm);
		getContentPane().setLayout(null);

		
		
		
		
		// Adiciona o JTabbedPane à janela principal
		getContentPane().add(tabbedPane);

		// Exibe a janela
		setVisible(true);

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

	private void adicionarAba(String titulo, Component conteudo) {
		tabbedPane.addTab(titulo, conteudo);
	}

	public static void main(String[] args) {
		// Garante que o código Swing seja executado na thread de despacho de eventos
		// (Event Dispatch Thread)
		SwingUtilities.invokeLater(() -> new TelaBlog(connect));
	}
}