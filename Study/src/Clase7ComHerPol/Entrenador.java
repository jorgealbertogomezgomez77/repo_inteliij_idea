package Clase7ComHerPol;

public class Entrenador extends Persona {
    private int duracion;

    public Entrenador() {

    }

    public Entrenador(int duracion) {
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
}
