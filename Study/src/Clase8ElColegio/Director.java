package Clase8ElColegio;

public class Director extends Persona {
    private double valoracion;

    public Director() {

    }

    public Director(String nombre, String apellido, String DNI, double valoracion) {
        super(nombre, apellido, DNI);
        this.valoracion = valoracion;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}
