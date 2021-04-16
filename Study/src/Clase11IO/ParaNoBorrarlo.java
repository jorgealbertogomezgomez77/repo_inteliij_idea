/*package Clase11IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ParaNoBorrarlo {

    // Todo esto dentro de un metodo main.
    String nombreDeArchivo = "hola.pdf";
    FileWriter escribiendo;
    try {
        // Abriendo el flujo.
        escribiendo = new FileWriter(nombreDeArchivo);
        // Trabajando con el flujo.
        for (int i = 0; i <= 15; i++) {
            escribiendo.write("Vito te quiero.  " + i + " - Estoy probando a ver si funciona esto que estoy escribiendo como una lectura.\n");
        }
        // Cerrar el flujo.
        escribiendo.close();
    }
    catch (IOException e) {
        System.out.println("No se ha podido Leer/Escribir el archivo.");
    }

    FileReader leyendo;
    try {
        leyendo = new FileReader(nombreDeArchivo);
        int character;
        character = leyendo.read();
        while (character != -1) {
            System.out.print((char)character);
            character = leyendo.read();
        }
        leyendo.close();

    }
    catch (IOException e) {
        System.out.println("No se ha podido Leer/Escribir el archivo.");
    }
}*/




/*FileReader lector = new FileReader("hola.txt");
        BufferedReader br = new BufferedReader(lector);
        String cadena = br.readLine();
        while (cadena != null) {
        System.out.println(cadena);
        cadena = br.readLine();*/




/*
InputStreamReader teclado = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(teclado);
        String aux;
        aux = br.readLine();
        System.out.println("Ha leido = " + aux);
 */




/*File fichero = new File(".");
        File[] directorio = fichero.listFiles();
        for (int i = 0; i < directorio.length; i++) {
            if (directorio[i].isDirectory()) {
                System.out.println("-->" + directorio[i].getName());
            }
            if (directorio[i].isFile()) {
                System.out.println("--" + directorio[i].getName() + " Tamaño: " + directorio[i].length());
                System.out.println();
            }
        }
        */