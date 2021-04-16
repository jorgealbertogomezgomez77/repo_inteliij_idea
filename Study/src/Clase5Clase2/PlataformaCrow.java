package Clase5Clase2;

public class PlataformaCrow {
    private String nombre;
    private double dineropropio;
    private static double dinerototal = 0.0;

    public PlataformaCrow(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public double getDineropropio() {
        return dineropropio;
    }

    public static double getDinerototal() {
        return dinerototal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDineropropio(double dineropropio) {
        this.dineropropio = dineropropio;
    }

    public static void setDinerototal(double dinerototal) {
        PlataformaCrow.dinerototal = dinerototal;
    }

    public void asignarDinero(double cantidaddinero) {
        dinerototal = dinerototal - cantidaddinero;
        this.dineropropio = dineropropio;
    }

    public static void recogerDinero(double dinero) {
        PlataformaCrow.dinerototal += dinero;
    }

    public static void imprimedineroTotal() {
        System.out.println("El dinero tatal del que se dispone es de " + dinerototal);
    }
}
