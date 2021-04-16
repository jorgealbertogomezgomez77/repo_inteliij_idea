package Clase9AlgoritmosYBusqueda;

public class Clase9Arrays {

    // Búsqueda secuencial no ordenada.
    public static int BusquedaSecNoOrd(int elemento, int[] a) {
        int  i = 0;
        boolean encontrado = false;
        while ((i < a.length) || (encontrado == false)) {
            if (a[i] == elemento) {
                encontrado = true;
                return a[i];
            }
            i++;
        }
        return -1;
    }

    public static int BusquedaBinaria(int elemento, int[] a) {
        int inf = 0;
        int sup = a.length - 1;
        boolean encontrado = false;
        while ((encontrado == false) && (sup >= inf)) {
            int central = (inf + sup) / 2;
            if (a[central] == elemento) {
                encontrado = true;
                return a[central];
            }
            else if (elemento > a[central]){
                inf = central + 1;
            }
            else {
                sup = central - 1;
            }
        }
        return -1;
    }

    public static void BurbujaCreciente(int[] a) {
        int aux;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1]  = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Definición de array de una dimensión.
        int[] a = {1,2,3,4,5,6,7,8,9};
        //BurbujaCreciente(a);
        BusquedaSecNoOrd(7, a);
        /*for (int w = 0; w < a.length; w++) {
            System.out.print(a[w] + "|");
        }*/
        System.out.println("El resultado es: " + BusquedaBinaria(3, a));
    }
}