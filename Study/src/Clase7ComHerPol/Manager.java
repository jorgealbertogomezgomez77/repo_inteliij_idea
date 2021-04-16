package Clase7ComHerPol;

public class Manager extends Persona {
    private int popularidad;

    public Manager() {

    }

    public Manager(int popularidad) {
        this.popularidad = popularidad;
    }

    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }
}
