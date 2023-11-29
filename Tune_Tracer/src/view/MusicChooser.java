package view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MusicChooser extends JFrame {
    private static final String CONFIG_FILE = "config.txt";
    private static String selectedMusicPath = null;
    private JButton chooseButton;
    private ImageIcon ocarina = new ImageIcon("imagens/ocarina.png");

    public MusicChooser() {
        loadConfig();

        setTitle("Escolha de Música");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setIconImage(ocarina.getImage());

        chooseButton = new JButton("Escolher Música");
        add(chooseButton);

        setLocationRelativeTo(null);

        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(MusicChooser.this);

                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedMusicPath = fileChooser.getSelectedFile().getAbsolutePath();
                    saveConfig();
                    playBackgroundMusic();
                }
            }
             
        });
        
        JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(255, 145, 77));
		setJMenuBar(barra);
		
		JMenu btnMenu = new JMenu("Menu");
		btnMenu.setForeground(new Color(255, 255, 255));
		barra.add(btnMenu);
		
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

        if (selectedMusicPath != null) {
            playBackgroundMusic();
        }

        setVisible(true);
    }

    private void loadConfig() {
        try {
            File configFile = new File(CONFIG_FILE);
            if (configFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(configFile));
                selectedMusicPath = reader.readLine();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveConfig() {
        try {
            PrintWriter writer = new PrintWriter(CONFIG_FILE);
            writer.println(selectedMusicPath);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void playBackgroundMusic() {
        MusicPlayer musicPlayer = MusicPlayer.getInstance();

        // Feche o clipe atual antes de abrir um novo
        musicPlayer.closeClip();

        // Tocar a nova música
        musicPlayer.play(selectedMusicPath);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MusicChooser();
        });
    }
}
