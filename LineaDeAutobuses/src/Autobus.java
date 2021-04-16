import java.util.Arrays;

public class Autobus {
    private String origen;
    private String destino;
    private int duracion;
    Pasajero[] pasajeros;

    public Autobus() {

    }

    public Autobus(String origen, String destino, int duracion, Pasajero[] pasajeros) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.pasajeros = pasajeros;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        return "Autobus{" + "origen='" + origen + '\'' + ", destino='" + destino + '\'' + ", duracion=" + duracion + ", pasajeros=" + Arrays.toString(pasajeros) + '}';
    }
}
