
package lawebdelprogramador.www;

import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author Jorge Alberto Gomez Gomez, January 13 the 2019, 03:13 PM
 */

public class Abrir_Guardar_Bytes {      // Main class of the program ...................................................

    public static void main(String[] args) {        // Start to the program.............................................
        new Abrir_Guardar_Bytes();
    }

    public Abrir_Guardar_Bytes() {      // Building of the class........................................................
        System.out.println("Iniciando Constructor....................................................................");
        open.setSelectedFile(new File("D://Fotos"));
        if (open.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                file = open.getSelectedFile();
                BufferedImage Img = ImageIO.read(file);
                bye = new byte[Img.getWidth() * Img.getHeight()];

                fileEntrada = new FileInputStream(file);
                fileEntrada.read(bye);
            }
            catch (Exception e) {

            }

            if (open.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                try {
                    file = open.getSelectedFile();
                    fileSalida = new FileOutputStream(file);
                    fileSalida.write(bye);
                }
                catch (Exception e) {

                }
            }
        }
    }

    JFileChooser open = new JFileChooser();
    File file;
    byte bye[];
    FileInputStream fileEntrada;
    FileOutputStream fileSalida;
}
