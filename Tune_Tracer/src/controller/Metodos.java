package controller;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
<<<<<<< HEAD

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
=======
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import model.dao.ConexaoSQL;
import model.dao.FavoritosInsertDAO;
import model.vo.FavoritosVO;

import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class Metodos {

    private static Clip tap;
    static ConexaoSQL sq = new ConexaoSQL();
	static CadastroController cadastroCon = new CadastroController(sq);
>>>>>>> f85773fe233a9ea0d7d7487e21c7e6acd20e30c5

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

<<<<<<< HEAD
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
=======
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void keyboardSound() {
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("songs/pianinho.wav"));
            tap = AudioSystem.getClip();
>>>>>>> f85773fe233a9ea0d7d7487e21c7e6acd20e30c5

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

<<<<<<< HEAD
=======
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
    
    


  
    
    
    
>>>>>>> f85773fe233a9ea0d7d7487e21c7e6acd20e30c5
}
