package view;

import javax.swing.*;

import controller.Metodos;
import model.dao.ConexaoSQL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;

public class MusicasDeExemplo extends JFrame {

	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private JPanel panel;
	private JScrollPane scrollPane;
	private JButton btnRolar;
	private JTextArea textArea;
	private JComboBox<String> comboBox;

	public MusicasDeExemplo() {

		setTitle("Tune Tracer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(730, 500);
		setResizable(false);
		setIconImage(ocarina.getImage());
		setLocationRelativeTo(null);

		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		Metodos.verificaTema(panel);

		scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setValue(0);

		getContentPane().add(scrollPane);

		btnRolar = new JButton("Auto Rolagem");
		btnRolar.setPreferredSize(new Dimension(150, 30));

		btnRolar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int scrollSpeed = 1;

				Timer timer = new Timer(50, new ActionListener() {
					int scrollValue = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						scrollValue += scrollSpeed;
						scrollPane.getVerticalScrollBar().setValue(scrollValue);

						if (scrollValue >= panel.getHeight() - scrollPane.getViewport().getHeight()) {
							((Timer) e.getSource()).stop();
						}
					}
				});

				timer.start();
			}
		});

		// Adicione o botão ao painel usando um layout FlowLayout
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		buttonPanel.add(btnRolar);
		panel.add(buttonPanel);

		// Adicione um JTextArea abaixo do botão
		textArea = new JTextArea();
		textArea.setEditable(false);
		panel.add(textArea);

		// Obtendo o arquivo txt da música "Eu só quero um xodó"
		Path caminho = Paths.get("musicas-de-exemplo/evidencias.txt");
		try {
			byte[] texto = Files.readAllBytes(caminho);
			String leitura = new String(texto);

			// Adiciona o conteúdo do arquivo à JTextArea
			textArea.setText(leitura);
		} catch (Exception e) {
		}

		// adicionando comboBox
		comboBox = new JComboBox<>();
		comboBox.addItem("Evidências");
		comboBox.addItem("Somewhere only we know");
		comboBox.addItem("Pudim Amassado");
		buttonPanel.add(comboBox);

		// Adicione um ouvinte ao JComboBox para tratar a seleção de itens
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Verifique qual item está selecionado
				String selectedItem = (String) comboBox.getSelectedItem();

				// Carregue o conteúdo do arquivo correspondente
				Path caminhoDoArquivo = null;
				switch (selectedItem) {
				case "Evidências":
					caminhoDoArquivo = Paths.get("musicas-de-exemplo/evidencias.txt");
					break;
				case "Somewhere only we know":
					caminhoDoArquivo = Paths.get("musicas-de-exemplo/somewhere.txt");
					break;
				case "Pudim Amassado":
					caminhoDoArquivo = Paths.get("musicas-de-exemplo/pudim.txt");
					break;
				// Adicione outros casos conforme necessário

				default:
					break;
				}

				// Tente ler o arquivo e definir o conteúdo na JTextArea
				if (caminhoDoArquivo != null) {
					try {
						byte[] texto = Files.readAllBytes(caminhoDoArquivo);
						String leitura = new String(texto);

						// Adiciona o conteúdo do arquivo à JTextArea
						textArea.setText(leitura);
					} catch (Exception ex) {
						// Trate exceções aqui, se necessário
						ex.printStackTrace();
					}
				}
			}
		});

		// configuração do menu

		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);

		JMenu btnMenu = new JMenu("Menu");
		btnMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMenu);

		JMenuItem setting = new JMenuItem("Configurações");
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
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MusicasDeExemplo();
			}
		});
	}
}
