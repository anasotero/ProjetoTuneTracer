package view;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import model.dao.ConexaoSQL;
import model.dao.FavoritosInsertDAO;
import model.vo.FavoritosVO;
import controller.Metodos;

@SuppressWarnings("serial")
public class TelaNotaGenerica extends JFrame {
	
	ConexaoSQL conexaoSQL = ConexaoSQL.getInstance(); // Obtenha uma instância da classe de conexão
	Connection conexao = conexaoSQL.getConect();

	private ConexaoSQL sq;

	Color CorFundo = new Color(255, 245, 239);
	Color CorPanel = new Color(255, 145, 77);

	Font fonte = new Font("Arial", Font.PLAIN, 26);

	ImageIcon C = new ImageIcon("imagens/C.jpeg");
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	ImageIcon favoritado = new ImageIcon("imagens/estrelaPreta.png");
	ImageIcon favoritadoRE = new ImageIcon(favoritado.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	ImageIcon favoritado2 = new ImageIcon("imagens/estrelaAmarela.png");
	ImageIcon favoritadoRE2 = new ImageIcon(favoritado2.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	ImageIcon som = new ImageIcon("imagens/som.png");
	ImageIcon som2 = new ImageIcon(som.getImage().getScaledInstance(39, 39, Image.SCALE_DEFAULT));

	JLabel estrelaDesativada = new JLabel(favoritadoRE);
	JLabel estrelaAtivada = new JLabel(favoritadoRE2);
	JLabel imagemC = new JLabel(C);
	JLabel nota_C = new JLabel("C");
	JLabel lblSom = new JLabel(som2);
	JPanel panel = new JPanel();

	public TelaNotaGenerica() {
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
		// configurações do panel
		panel.setBounds(298, 35, 177, 56);
		getContentPane().add(panel);
		panel.setBackground(CorPanel);
		panel.setLayout(null);
		nota_C.setBounds(77, 14, 22, 24);
		panel.add(nota_C);

		// configurações do JLabel (nota C)
		nota_C.setFont(fonte);
		nota_C.setForeground(Color.white);

		// configurações da foto da nota
		imagemC.setLayout(null);
		imagemC.setBounds(219, 101, 330, 338);
		getContentPane().add(imagemC);

		// configurações da foto do ícone do som
		lblSom.setLayout(null);
		lblSom.setVisible(false);
		lblSom.setBounds(660, 391, 40, 40);
		getContentPane().add(lblSom);
		lblSom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Metodos.som_C_Violao();
			}
		});
		setVisible(true);
	}

	private void favoritarNOTA() {

		try (Connection conected = sq.getConect()) {
			FavoritosVO FV = new FavoritosVO("C", "Violão");
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
	}

	public static void main(String[] args) {
		new TelaNotaGenerica();
	}

}
