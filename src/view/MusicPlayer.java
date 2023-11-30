package view;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    private static MusicPlayer instance;
    private Clip clip;

    private MusicPlayer() {
        // Inicialize o Clip apenas uma vez no construtor
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void closeClip() {
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.close();
        }
    }


    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public void play(String musicFilePath) {
        try {
            // Pare a reprodução atual, se houver
            closeClip();

            // Carregue e inicie a nova música usando o caminho fornecido
            File audioFile = new File(musicFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip.open(audioInputStream);

            // Configure a reprodução em loop contínuo
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }


    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void playSelectedMusic(String musicFilePath) {
        play(musicFilePath);
    }
}
