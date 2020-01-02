import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    // A la función se le pasa la tabla, el elemento a buscar y la primera
    // y última posición donde buscar.
    static int busca(int t[], int elem, int primero, int ultimo) {
        int pos;
        if (primero >= ultimo) { // Caso base: Solo hay un elemento donde buscar.
            if (t[primero] == elem) {
                pos = primero;
            }
            else {
                pos = -1;
            }
        }
        else {
            int pos1, pos2;
            // Llamada recursiva.
            // Buscamos en la primera mitad de la tabla: 0..mitad.
            pos1 = busca(t, elem, primero, (primero + ultimo) / 2);
            // Buscamos en la segunda parte de la tabla: mitad + 1..ultimo.
            // Se pone mitad + 1, por que el elemento mitad ya pertenece a la
            // primera parte... para no repetirlo.
            pos2 = busca(t, elem, (primero + ultimo) / 2 + 1, ultimo);
            if (pos1 != -1) {
                pos = pos1;
            }
            else {
                pos = pos2; // En caso contrario debo encontrarlo en la segunda parte
                // En caso de no encontrarse pos1 y pos2 serán -1, y se cogerá el
                // valor de pos2 (-1).
            }
        }
        return pos;
    }
    // El usuario utilizará esta función por comodidad.
    // Solo es necesario pasarle la tabla y el elemento a buscar.
    // Devuelve el índice del elemento si lo encuentra o -1 en caso contrario.

    static int busca(int t[], int elem) {
        return busca(t, elem, 0, t.length - 1);
    }

    public static void main(String[] args) {
        int datos[];
        int num;
        int pos;
        datos = new int[10];
        // Para no teclearlos, cargamos datos aleatoreos.
        for (int i = 0; i < datos.length; i++) {
            datos[i] = (int) (Math.random() * 1000 + 1);
            System.out.println("Los datos son: ");
        }
        for (int i = 0; i < datos.length; i++) {
            System.out.println(datos[i] + " ");
            System.out.println("\n\n Elemento a buscar: ");
            num = entero();
            // Llamamos a la función buscar.
            pos = busca(datos, num);
            if (pos == -1) {
                System.out.println("\n\n No encontrado.");
            }
            else {
                System.out.println("\n\n Encontrado en la posición: " + pos);
            }
        }
    }

    static int entero() {
        int valor = Integer.parseInt(inicializar());
        return valor;
    }

    static String inicializar() {
        String buzon = "";
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        try {
            buzon = teclado.readLine();
        }
        catch (Exception e) {
            System.out.println("Entrada incorrecta.");
        }
        return buzon;
    }
}
