package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import view.TelaCadastro;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.CadastroController;
import model.dao.ConexaoSQL;

public class SplashScreenExample extends JFrame{

	
	static ConexaoSQL sq = new ConexaoSQL();
	static CadastroController cadastroCon = new CadastroController(sq);
	
	public SplashScreenExample(){
		
		}

	public static void main(String[] args) {
		SplashScreen splash = new SplashScreen(11840);
		
		splash.showSplash();
		splash.hideSplash();
		
		new TelaCadastro(cadastroCon, sq);
	}
}

class SplashScreen extends JFrame {

	private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
	private int duration;


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
}