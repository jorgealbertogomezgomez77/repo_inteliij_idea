package Clase7ComHerPol;

public class Futbolista extends Persona {
    private String posicion;
    private double valor;

    public Futbolista(String nombre, String apellido, String DNI) {
        super(nombre, apellido, DNI);
    }

    public Futbolista(String posicion, double valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    public Futbolista() {

    }

    public String getPosicion() {
        return posicion;
    }

    public double getValor() {
        return valor;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void imprime() {
        super.imprime();
        System.out.println(" Posicion:" + this.getPosicion() + " Valor: " + this.getValor());
    }
}
