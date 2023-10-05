package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class config extends JFrame {

<<<<<<< HEAD
	ImageIcon ocarina = new ImageIcon(getClass().getResource("ocarina.png"));
=======
	ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");
>>>>>>> 7e54e61dd832634c2170593260ec180afdf25d2f
	Color fundo = new Color(255, 245, 239);

	public config() {

		setTitle("Tune Tracer");
		setResizable(false);
		setFont(new Font("Arial", Font.PLAIN, 12));
		setBounds(1080, 720, 780, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(ocarina.getImage());
		getContentPane().setBackground(fundo);
		//só pra teste
		
		
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new config();
	}
}
