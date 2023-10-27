package controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import model.dao.ConexaoSQL;

import java.awt.SplashScreen;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.SplashScreenExample;
import view.TelaEscolhaDeInstrumento;

public class Metodos {

	private static Clip tap;
	private static ConexaoSQL sq;
	private static LoginController logcon;
	private static Connection conect;

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

	public static boolean manterSessaoAtivado(Connection conect) throws SQLException {
		String sql = "UPDATE manterSessão SET verificador = 1 WHERE id = 1";

		try (PreparedStatement st = conect.prepareStatement(sql)) {
			int rowsUpdated = st.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static boolean manterSessaoDesativado(Connection conect) throws SQLException {
		String sql = "UPDATE manterSessão SET verificador = 0 WHERE id = 1";

		try (PreparedStatement st = conect.prepareStatement(sql)) {
			int rowsUpdated = st.executeUpdate();
			return rowsUpdated > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

}
