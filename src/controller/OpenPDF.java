package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenPDF {

    public static void abrirManual () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/manual.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void abrirBlogCifra () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/blogCifra.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void abrirBlogCampo () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/campo.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void abrirBlogHistoria () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/historia.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void abrirBlogPartituras () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/PARTITURAS.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void abrirBlogTipos () {
        try {
            // Caminho para o arquivo PDF
            String filePath = "blogs/tipos.pdf";

            // Verifica se o Desktop é suportado
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();

                // Verifica se o arquivo existe
                File file = new File(filePath);
                if (file.exists()) {
                    desktop.open(file);
                } else {
                    System.out.println("O arquivo não existe.");
                }
            } else {
                System.out.println("Desktop não suportado.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}