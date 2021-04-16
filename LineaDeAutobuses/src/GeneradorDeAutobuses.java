import java.util.Random;

public class GeneradorDeAutobuses {

    public static Autobus[] generarAutobuses(int n) {
        String[] lorigenes = {"Cuenca", "Madrid", "Malaga", "Hong Kong", "Almeria"};
        String[] ldestinos = {"Cuenca", "Madrid", "Malaga", "Hong Kong", "Almeria"};
        Autobus[] resultado = new Autobus[n];

        for (int i = 0; i < n; i++) {
            Random r = new Random();
            Autobus a = new Autobus();
            a.setOrigen(lorigenes[r.nextInt(lorigenes.length)]);
            a.setDestino(ldestinos[r.nextInt(ldestinos.length)]);
            a.setDuracion(r.nextInt(600));
            a.setPasajeros(GeneradorPasajeros.generarPasajeros(20));

            resultado[i] = a;
        }
        return resultado;
    }
}
