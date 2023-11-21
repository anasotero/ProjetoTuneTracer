package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import view.TelaCadastro;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.CadastroController;
import controller.LoginController;
import controller.Metodos;
import model.dao.ConexaoSQL;

public class SplashScreenExample extends JFrame {

	private static Connection conect;
	static ConexaoSQL sq = new ConexaoSQL();
	static CadastroController cadastroCon = new CadastroController(sq);
	static LoginController logcon = new LoginController(sq);
	

	public SplashScreenExample() {

	}

	public static void main(String[] args) {
		SplashScreenExample splashScreen = new SplashScreenExample();
		SplashScreen splash = new SplashScreen(11840);

		// Inicialize a conexão com o banco de dados
		conect = ConexaoSQL.getInstance().getConect();

		try {
			SplashScreen.verificaManterSessao(conect, splashScreen, logcon);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

class SplashScreen extends JFrame {

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private int duration;
	static ConexaoSQL sq = new ConexaoSQL();
	static CadastroController cadastroCon = new CadastroController(sq);
	static LoginController logcon = new LoginController(sq);

	public SplashScreen(int duration) {
		this.duration = duration;
	}

	public void showSplash() {
		JPanel content = new JPanel();

		// Use a imagem desejada para o splash screen
		ImageIcon splashIcon = new ImageIcon("imagens/animacao.gif");
		ImageIcon splashIcon2 = new ImageIcon(splashIcon.getImage().getScaledInstance(1000, 500, Image.SCALE_DEFAULT));
		JLabel label = new JLabel(splashIcon2);
		content.add(label);

		// Configurando a janela de splash
		setUndecorated(true);
		getContentPane().add(content);
		pack();
		setVisible(true);
		setBounds(1080, 780, 760, 500);
		setIconImage(ocarina.getImage());
		setLocationRelativeTo(null);

		// Aguarda o tempo especificado (em milissegundos)
		try {
			Thread.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void hideSplash() {
		setVisible(false);
		dispose();
	}

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 633219cb63cddc3c928213ee0ec0b1636e231544
>>>>>>> d00be894dcb8ad52549d2474cbbdecc1899c48e3
>>>>>>> 270fd610e27dfd02873de75846223d3b7c0fb44e
	public static void verificaManterSessao(Connection conect, SplashScreenExample splashScreen, LoginController logcon2) throws SQLException {
		String sql = "SELECT verificador FROM manterSessão WHERE id = 1";

		try (PreparedStatement st = conect.prepareStatement(sql)) {
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next()) {
				int verificador = resultSet.getInt("verificador");
				if (verificador == 1) {
					
					TelaEscolhaDeInstrumento TL = new TelaEscolhaDeInstrumento();
					TL.setVisible(true);
					MusicPlayer musicPlayer = MusicPlayer.getInstance();
					String selectedMusicPath = loadSelectedMusicPath();

					if (selectedMusicPath != null) {
						musicPlayer.play(selectedMusicPath); // Reproduza a música de fundo automaticamente
					}
					splashScreen.setVisible(false);
					
				} else if (verificador == 0) {
					SplashScreen newSplash = new SplashScreen(10000);
					newSplash.showSplash();
					newSplash.hideSplash();
					splashScreen.setVisible(false);

					new TelaCadastro(cadastroCon, sq, logcon2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	private static String loadSelectedMusicPath() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
			String selectedMusicPath = reader.readLine();
			reader.close();
			return selectedMusicPath;
		} catch (IOException e) {
			return null;
		}
	}
}
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
=======
        try (PreparedStatement st = conect.prepareStatement(sql)) {
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                int verificador = resultSet.getInt("verificador");
                if (verificador == 1) {
                    TelaEscolhaDeInstrumento TL = new TelaEscolhaDeInstrumento();
                    TL.setVisible(true);
                    splashScreen.setVisible(false);
                } else if (verificador == 0) {
                    SplashScreen newSplash = new SplashScreen(10000);
                    newSplash.showSplash();
                    newSplash.hideSplash();
                    splashScreen.setVisible(false);
                    
                    new TelaCadastro(cadastroCon, sq);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
>>>>>>> 56a682ac4de501ac07a836df713f630aae5741a2
>>>>>>> 633219cb63cddc3c928213ee0ec0b1636e231544
>>>>>>> d00be894dcb8ad52549d2474cbbdecc1899c48e3
>>>>>>> 270fd610e27dfd02873de75846223d3b7c0fb44e
