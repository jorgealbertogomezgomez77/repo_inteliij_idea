
/**
 * Programa que genera un arreglo con tamaño aleatorio de enteros aleatorios
 * e imprime un histograma de frecuencias
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Histogramas {
    private static String repeat(String what, int howMany) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < howMany; i++) {
            buf.append(what);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Random generator = new Random();
        // Genera números aleatorios entre 0 y 20
        int[] nums = new int[generator.nextInt(20)];

        for (int i = 0; i < nums.length; i++) {
            // Números aleatorios entre 0 y 10
            nums[i] = generator.nextInt(10);
        }
        // Creamos una tabla que guarde el número y su cantidad de ocurrencias
        // No se pueden usar tipos primitivos en este tipo de estructuras
        HashMap<Integer, Integer> tabla = new HashMap<Integer, Integer>();

        System.out.printf("Números generados: \n %s\n", Arrays.toString(nums));

        for (int num: nums) {
            Integer index = new Integer(num);
            if (!tabla.containsKey(index)) {
                tabla.put(index, new Integer(1));
            }
            else {
                tabla.put(index, tabla.get(index) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> fila: tabla.entrySet()) {
            System.out.printf("%s: %s\n", fila.getKey(), repeat("*", fila.getValue().intValue()));
        }
    }
}
