
package com.capitulo_1;

import java.util.ArrayList;

public class exercise_3 {
    public static void main(String[] args) {
        String english[] = {"East", "North", "Street", "Revolution", "Congratulation", "Car", "Cat", "Elephant", "Wine", "Sweet"};
        String spanish[] = {"Este", "Norte", "", "Calle", "Revolucion", "Felicidades", "Carro", "Gato", "Elefante", "Vino", "Dulce"};

        contarCaracteres(english);
        ordenarArray(contarCaracteres(english));

        /*System.out.println("East" + "\t\t\tEste");
        System.out.println("Norh" + "\t\t\tNorte");
        System.out.println("Steel" + "\t\t\tAcero");
        System.out.println("Revolution" + "\t\ttRevolucion");
        System.out.println("Congratulation" + "\tFelicidades");
        System.out.println("Car" + "\t\t\t\tCarro");
        System.out.println("Cat" + "\t\t\t\tGato");
        System.out.println("Elephant" + "\t\tElefante");
        System.out.println("Wine" + "\t\t\tVino");
        System.out.println("Sweet" + "\t\t\tDulce");*/
    }

    public static int[] contarCaracteres(String[] arreglo) {
        ArrayList<Integer> array= new ArrayList<Integer>();
        for (int i = 0; i < arreglo.length; i++) {
            int caracteres = arreglo[i].length();
            array.add(caracteres);
        }
        System.out.println(array);
        return array;
    }

    public static int[] ordenarArray(int arreglo[]) {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    int varaux = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = varaux;
                }
            }
        }
        return arreglo;
    }
}
