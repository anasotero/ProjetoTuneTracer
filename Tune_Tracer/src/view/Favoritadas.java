package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Favoritadas extends JFrame {
	
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	Color CorFundo = new Color(255, 245, 239);
	Color CorLaranja = new Color(255,192,131);

	private JTable tabela;
    private DefaultTableModel model;
    private JPanel contentPane;
    private static Connection connect;

    public Favoritadas(Connection connect) {
    	
    	this.connect = connect;
    	
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

        model = new DefaultTableModel();
        tabela = new JTable(model);
        
        tabela.setBackground(CorFundo);

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
        header.setBackground(CorFundo);

        carregarRegistrosDoBancoDeDados();
        
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
     		
     		JMenuItem retornar = new JMenuItem("Retornar");
     		retornar.setMnemonic('R');
     		retornar.setBackground(new Color(255, 255, 255));
     		retornar.setForeground(new Color(255, 128, 0));
     		btnMenu.add(retornar);
     		setVisible(true);
     		
     		retornar.addActionListener(new ActionListener() {
     		    @Override
     		    public void actionPerformed(ActionEvent e) {
     		        TelaEscolhaDeInstrumento TDI = new TelaEscolhaDeInstrumento(connect);
     		        TDI.setVisible(true);
     		        dispose();
     		    }
     		});

        setLocationRelativeTo(null);
    }

    private void carregarRegistrosDoBancoDeDados() {
        String url = "jdbc:mysql://localhost:3306/tune_tracer";
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

    public static void main(String[] args) {
    	
            new Favoritadas(connect);

    }

}
