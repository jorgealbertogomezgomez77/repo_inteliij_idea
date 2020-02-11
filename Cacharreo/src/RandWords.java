import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class RandWords {

    private static String genPalabra() {
        Random gen = new Random();

        // La palabra mas larga en espaniol dicen que tiene 27 letras
        byte[] bytes = new byte[gen.nextInt(27)];
        // Llenar el arreglo con bytes aleatorios
        // gen.nextBytes(bytes);

        for (int i = 0; i < bytes.length; i++) {
            // El byte tiene que estar en el rango [97, 122] (letras minúsculas)
            // Para generar aleatorios en un rango : (fin - inicio + 1) * gen.nextDouble() + inicio;
            bytes[i] = (byte) (26 * gen.nextDouble() + 97);
        }
        return new String(bytes);
    }

    public static void main(String[] args) {
        // Instanciar el generador de aleatorios
        Random gen = new Random();
        // Obtener el número de palabras de la linea de comandos:
        int numPalabras = args.length == 1 ? Integer.parseInt(args[0]) : gen.nextInt(200);
        // Guardar las palabras en un ArrayList:
        ArrayList<String> palabras = new ArrayList<String>();
        // Llenar el ArrayList con n palabras al azar:

        for (int i = 0; i < numPalabras; i++) {
            palabras.add(genPalabra());
        }
        //Ordenar el ArrayList e imprimirlo
        Collections.sort(palabras);
        System.out.printf("La lista ordenada Lexicográficamente: \n %s \n", palabras.toString().replace(",", "\n"));
    }
}
