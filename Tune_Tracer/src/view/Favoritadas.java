package view;

import java.awt.*;
import java.awt.event.*;
import java.io.ObjectInputFilter.Config;
import java.nio.file.DirectoryStream.Filter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.Metodos;
import model.dao.ConexaoSQL;
import model.vo.FavoritosVO;

public class Favoritadas extends JFrame {

	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	Color CorFundo = new Color(255, 245, 239);
	Color CorLaranja = new Color(255, 192, 131);
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private JTable tabela;
	private DefaultTableModel model;
	private JPanel contentPane;
	private static String opcao;

	public Favoritadas() {
		setTitle("Tune Tracer");
		setResizable(false);
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		setBackground(CorFundo);

		contentPane = new JPanel();
		contentPane.setBackground(CorLaranja); // Defina a cor de fundo do painel
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Metodos.verificaTema(contentPane);

		model = new DefaultTableModel();
		tabela = new JTable(model);

		tabela.setBackground(CorFundo);
		tabela.setForeground(Color.BLACK);
		Font fonte = tabela.getFont();
        fonte = fonte.deriveFont(Font.BOLD, 16f);

		JScrollPane scrollPane = new JScrollPane(tabela);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setBackground(CorFundo);

		// Defina a cor de fundo das células
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		cellRenderer.setBackground(CorFundo);
		tabela.setDefaultRenderer(Object.class, cellRenderer);

		// Defina a cor de fundo do cabeçalho da tabela
		JTableHeader header = tabela.getTableHeader();
		header.setForeground(Color.BLACK);
		header.setBackground(CorFundo);

		carregarRegistrosDoBancoDeDados(null);

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
		
		JMenu filtrar = new JMenu("Filtrar");
		filtrar.setForeground(new Color(255, 255, 255));
		barra.add(filtrar);
		
		JMenuItem btnViolao = new JMenuItem("Violão");
		btnViolao.setFont(new Font("Arial", Font.BOLD, 14));
		btnViolao.setMnemonic('V');
		btnViolao.setBackground(new Color(255, 255, 255));
		btnViolao.setForeground(new Color(255, 120, 0));
		filtrar.add(btnViolao);
		setVisible(true);
		
		btnViolao.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				carregarRegistrosDoBancoDeDadosViolão(opcao);
				
			}
		});
		
		JMenuItem btnFlauta = new JMenuItem("Flauta");
		btnFlauta.setFont(new Font("Arial", Font.BOLD, 14));
		btnFlauta.setMnemonic('F');
		btnFlauta.setBackground(new Color(255, 255, 255));
		btnFlauta.setForeground(new Color(255, 120, 0));
		filtrar.add(btnFlauta);
		setVisible(true);
		
		btnFlauta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				carregarRegistrosDoBancoDeDadosFlauta(opcao);
			
			}
		});
		
		JMenuItem btnTeclado = new JMenuItem("Teclado");
		btnTeclado.setFont(new Font("Arial", Font.BOLD, 14));
		btnTeclado.setMnemonic('T');
		btnTeclado.setBackground(new Color(255, 255, 255));
		btnTeclado.setForeground(new Color(255, 120, 0));
		filtrar.add(btnTeclado);
		setVisible(true);
		
		btnTeclado.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				carregarRegistrosDoBancoDeDadosTeclado(opcao);
			}
		});

		setLocationRelativeTo(null);
	}

	private void carregarRegistrosDoBancoDeDados(String instrumento) {
		String url = "jdbc:mysql://localhost:3306/tunetracer";
		String usuario = "root";
		String senha = "root";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha);
				Statement statement = conexao.createStatement()) {

			String query = "SELECT nota, instrumento FROM favoritos";
			ResultSet resultSet = statement.executeQuery(query);

			// Limpar a tabela antes de adicionar os novos dados
			model.setRowCount(0);

			// Adicionar as colunas à tabela
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				model.addColumn(resultSet.getMetaData().getColumnName(i));
			}

			// Adicionar os registros à tabela
			while (resultSet.next()) {
				Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	private void carregarRegistrosDoBancoDeDadosViolão(String instrumento) {
		String url = "jdbc:mysql://localhost:3306/tunetracer";
		String usuario = "root";
		String senha = "root";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

			String query = "SELECT nota, instrumento FROM favoritos WHERE instrumento = 'Violão' ";
			PreparedStatement statement = conexao.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			
			model.setRowCount(0);
			

			// Adicionar os registros à tabela
			while (resultSet.next()) {
				Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	private void carregarRegistrosDoBancoDeDadosFlauta(String instrumento) {
		String url = "jdbc:mysql://localhost:3306/tunetracer";
		String usuario = "root";
		String senha = "root";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

			String query = "SELECT nota, instrumento FROM favoritos WHERE instrumento = 'Flauta' ";
			PreparedStatement statement = conexao.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			
			model.setRowCount(0);
			

			// Adicionar os registros à tabela
			while (resultSet.next()) {
				Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
	private void carregarRegistrosDoBancoDeDadosTeclado(String instrumento) {
		String url = "jdbc:mysql://localhost:3306/tunetracer";
		String usuario = "root";
		String senha = "root";

		try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {

			String query = "SELECT nota, instrumento FROM favoritos WHERE instrumento = 'Teclado' ";
			PreparedStatement statement = conexao.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery(query);
			
			
			model.setRowCount(0);
			

			// Adicionar os registros à tabela
			while (resultSet.next()) {
				Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					row[i - 1] = resultSet.getObject(i);
				}
				model.addRow(row);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}

	public static void main(String[] args) {

		new Favoritadas();

	}

}
