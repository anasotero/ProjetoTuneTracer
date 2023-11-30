package controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import model.dao.ConexaoSQL;
import model.dao.FavoritosInsertDAO;
import model.vo.FavoritosVO;
import java.awt.Component;
import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Metodos {

	private static Clip tap;
	static ConexaoSQL sq = new ConexaoSQL();
	static CadastroController cadastroCon = new CadastroController(sq);

	public static void FavoritarNota(String nota, String instrumento) {
		try (Connection conected = sq.getConect()) {
			FavoritosVO FV = new FavoritosVO(nota, instrumento);
			FavoritosInsertDAO FID = new FavoritosInsertDAO(conected);
			FID.favoritar(FV);

		} catch (SQLException e) {
			System.err.println("Erro em favoritar nota " + e.getMessage() + "Erro");
		}

	}

	public static void Desfavoritar(String nota, String instrumento) {
		try (Connection conected = sq.getConect()) {
			FavoritosVO si = new FavoritosVO(nota, instrumento);
			FavoritosInsertDAO FID = new FavoritosInsertDAO(conected);
			FID.desfavoritar(si);

		} catch (SQLException e) {
			System.err.println("Erro em Desfavoritar nota " + e.getMessage() + "Erro");
		}
	}

	// métodos de som do sistema
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
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/pianinho.wav"));
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

	public static void C() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/C.wav"));
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

	public static void CS() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/CS.wav"));
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

	public static void D() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/D.wav"));
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

	public static void DS() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/DS.wav"));
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

	public static void E() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/E.wav"));
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

	public static void F() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/F.wav"));
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

	public static void FS() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/FS.wav"));
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

	public static void G() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/G.wav"));
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

	public static void GS() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/GS.wav"));
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

	public static void A() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/A.wav"));
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

	public static void AS() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/AS.wav"));
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

	public static void B() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/B.wav"));
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

	public static void doFlauta() {
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

	public static void reFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/re_flauta.wav"));
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

	public static void miFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/mi_flauta.wav"));
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

	public static void faFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/fa_flauta.wav"));
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

	public static void solFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/sol_flauta.wav"));
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

	public static void laFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/la_flauta.wav"));
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

	public static void siFlauta() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/si_flauta.wav"));
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

	// métodos de favoritar e desfavoritar
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

	public static boolean isTemaEscuro() {
		String lookAndFeel = UIManager.getLookAndFeel().getClass().getName();
		return lookAndFeel.contains("FlatDarkLaf");
	}

	public static void removerBackground(JComponent componente) {
		componente.setOpaque(false);
	}

	public static void verificaTema(JComponent componente) {
		if (isTemaEscuro()) {
			removerBackground(componente);
		} else {
		}
	}

	public static void som_CordaMizona() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_Mizona.wav"));
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

	public static void som_CordaLa() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_La.wav"));
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

	public static void som_CordaRe() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_Ree.wav"));
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

	public static void som_CordaSol() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_Sol.wav"));
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

	public static void som_CordaSi() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_Si.wav"));
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

	public static void som_CordaMizinha() {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/Corda_Mizinhaa.wav"));
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


