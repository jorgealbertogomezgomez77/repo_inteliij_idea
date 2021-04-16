public class DiagonalPrincipalSecundariaMatriz {
    public static void main(String[] args) {
        int[][] matriz = new int[5][5];
        inicializar(matriz);
        visualizarMatriz(matriz);
        int[] diagoPrincipal = new int[matriz.length];
        int[] diagoSecundaria = new int[matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j) {
                    diagoPrincipal[i] = matriz[i][j];
                }

                if (i + j == matriz.length - 1) {
                    diagoSecundaria[i] = matriz[i][j];
                }
            }
        }
        System.out.println("\nDiagonal Principal");
        visualizarArray(diagoPrincipal);

        System.out.println("\n\nDiagonal Secundaria");
        visualizarArray(diagoSecundaria);

        System.out.println("\n\n");
    }

    // Función que escribe un array de enteros y lo muestra por pantalla.
    static void visualizarArray(int[] pArray) {
        for (int i = 0; i < pArray.length; i++) {
            System.out.print("\t" + pArray[i]);
        }
    }

    // Función que rellena la matriz 5x5 con números consecutivos.
    static void inicializar(int[][] pMatriz) {
        int aux = 1;
        for (int i = 0; i < pMatriz.length; i++) {
            for (int j = 0; j < pMatriz[i].length; j++) {
                pMatriz[i][j] = aux;
                aux++;
            }
        }
    }

    // Función que muestra el contenido del array 5x5.
    static void visualizarMatriz(int[][] pMatriz) {
        System.out.println("\nArray 5x5");
        for (int i = 0; i < pMatriz.length; i++) {
            for (int j = 0; j < pMatriz[i].length; j++) {
                System.out.println("\t" + pMatriz[i][j]);
            }
            System.out.println();
        }
    }
}






















