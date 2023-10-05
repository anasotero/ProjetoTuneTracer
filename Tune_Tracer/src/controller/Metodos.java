package controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.File;

public class Metodos {

    private static Clip tap;

    public static void guitarSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/guitar.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void keyboardSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/keyboard.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void fluteSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/flute.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void clickedSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/clicked.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void favoritadoSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/favoritado.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void som_C_Flauta() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/c_flauta.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void som_C_Piano() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/c_piano.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void som_C_Violao() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/c_violao.wav"));
            tap = AudioSystem.getClip();

            tap.addLineListener(new LineListener() {
                public void update(LineEvent event) {

                    if (event.getType() == LineEvent.Type.STOP)
                        tap.close();
                }
            });

            tap.open(audioStream);
            tap.start();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

