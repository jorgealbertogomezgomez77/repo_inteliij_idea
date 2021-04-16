package Clase8ElColegio;

public class Delegado extends Alumno {
    private double valoracion;

    public Delegado() {

    }

    public Delegado(String nombre, String apellido, String DNI, String curso, double notamedia, double valoracion) {
        super(nombre, apellido, DNI, curso, notamedia);
        this.valoracion = valoracion;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }
}
